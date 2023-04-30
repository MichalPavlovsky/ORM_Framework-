package sk.michal.ormSimpleFramework.dbaccess;

import sk.michal.ormSimpleFramework.exceptions.AnnotationMissingException;
import sk.michal.ormSimpleFramework.reflection.ObjectReflector;
import sk.michal.ormSimpleFramework.sql.SqlBuilder;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class SormManager {
    public <T> T getEntityByid(Long id, Class<T> clazz) throws Exception {

        T o = null;
        if (id == null){
            throw new IllegalArgumentException("ID nemoze byt prazdne");
        }
        if (!ObjectReflector.isTable(clazz)) {
            throw new AnnotationMissingException("Objekt nema anotaciu tabulka.");
        }else {
            System.out.println("is table" +clazz.getName());
        }
        DataBaseAccess dataBaseAccess = null;
        ResultSet rs = null;
        try {
            dataBaseAccess = new DataBaseAccess();
            rs = loadData(id, clazz, dataBaseAccess);
            if (rs.next())
                o= ObjectReflector.getFilledData(rs, clazz);
            dataBaseAccess.commit();
        }catch (Exception e) {
            if (dataBaseAccess != null) {
                dataBaseAccess.rollBack();
            }
            throw new Exception(e);
        }finally {
            if (dataBaseAccess!= null) {
                dataBaseAccess.disconnect();
            }
        }


        //nacitame data z db


        //nasetujeme na objekt
        return o;
    }

    private <T> ResultSet loadData(Long id, Class<T> clazz, DataBaseAccess dataBaseAccess) throws Exception {
        String tableName = ObjectReflector.getTableName(clazz);
        List<String> tableColumns = ObjectReflector.getColumnNames(clazz);
        String idColumnName = ObjectReflector.getIdColumnName(clazz);

        String query = SqlBuilder.buildQuery(id, tableName, idColumnName, tableColumns);
        System.out.println(query);
        //ziskat resultSet


        return dataBaseAccess.executeQuery(query);
    }

    public <T> void insertEntity(T object) throws Exception {
        Class<?> clazz = object.getClass();
        String tableName = ObjectReflector.getTableName(clazz);
        List<String> tableColumns = ObjectReflector.getColumnNames(clazz);

        Map<String, Object> data = ObjectReflector.getObjectData(clazz);
        String query = SqlBuilder.buildInsertQuery(tableName, tableColumns, data);
        DataBaseAccess dataBaseAccess = new DataBaseAccess();
        dataBaseAccess.insert(query);

    }
}
