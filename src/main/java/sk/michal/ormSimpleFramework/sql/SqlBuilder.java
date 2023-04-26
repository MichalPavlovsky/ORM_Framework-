package sk.michal.ormSimpleFramework.sql;

import java.util.List;
import java.util.Map;

public class SqlBuilder {
    public static String buildQuery(Long id, String tableName, String idColumnName, List<String> tableColumns) {
        StringBuilder stlpce = new StringBuilder();
        for (String s: tableColumns) {
            stlpce.append(s).append(",");
        }
        String stlpceQuery = stlpce.toString().substring(0, stlpce.lastIndexOf(","));

        return String.format("SELECT %s FROM %s WHERE %s=%d", stlpceQuery, tableName, idColumnName, id);
    }

    public static String buildInsertQuery(String tableName, List<String> tableColumns, Map<String, Object> data) {
        StringBuilder stlpce= new StringBuilder();
        for (String s : tableColumns){
            stlpce.append(s).append(",");}

        String stlpceQuery = stlpce.toString().substring(0, stlpce.lastIndexOf(","));
        StringBuilder dataa= new StringBuilder();
        for (Object a : data.values()) {
            dataa.append(a).append(",");
        }
        String dataQuery = dataa.toString().substring(0, dataa.lastIndexOf(","));
        System.out.println(String.format("insert into %s(%s) VALUES (%s)",tableName,  stlpceQuery,dataQuery));


        return String.format("insert into %s(%s) VALUES (%s)",tableName,  stlpceQuery,dataQuery);
        //insert into MOVIE(REZISER, HLAVNA_ULOHA, ID) VALUES ('', '',0);

    }
}
