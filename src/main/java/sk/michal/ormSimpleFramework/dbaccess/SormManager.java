package sk.michal.ormSimpleFramework.dbaccess;

import sk.michal.ormSimpleFramework.exceptions.AnnotationMissingException;
import sk.michal.ormSimpleFramework.reflection.ObjectReflector;
import sk.michal.ormSimpleFramework.sql.SqlBuilder;
import sk.michal.testovaciProgram.entity.Film;

import java.sql.ResultSet;
import java.sql.SQLException;
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

        //nacitame data z db
        ResultSet result = loadData(id, clazz);
        System.out.println(result.getString("ADDRESS"));
        o= ObjectReflector.getFilledData(result, clazz);
        //nasetujeme na objekt
        return o;
    }

    private <T> ResultSet loadData(Long id, Class<T> clazz) {
        String tableName = ObjectReflector.getTableName(clazz);
        List<String> tableColumns = ObjectReflector.getColumnNames(clazz);
        String idColumnName = ObjectReflector.getIdColumnName(clazz);

        String query = SqlBuilder.buildQuery(id, tableName, idColumnName, tableColumns);
        System.out.println(query);
        //ziskat resultSet
        DataBaseAccess dataBaseAccess = new DataBaseAccess();

        return dataBaseAccess.executeQuery(query);
    }

    public <T> void insertEntity(T object) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = object.getClass();
        String tableName = ObjectReflector.getTableName(clazz);
        List<String> tableColumns = ObjectReflector.getColumnNames(clazz);

        Map<String, Object> data = ObjectReflector.getObjectData(clazz);
//        String query = SqlBuilder.buildInsertQuery(tableName, tableColumns, data);
//        DataBaseAccess dataBaseAccess = new DataBaseAccess();
//        dataBaseAccess.insert(query);
//        System.out.println(query);
        //insert into MOVIE(REZISER, HLAVNA_ULOHA, ID) VALUES ('', '',0);
    }
}
