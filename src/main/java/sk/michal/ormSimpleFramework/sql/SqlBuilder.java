package sk.michal.ormSimpleFramework.sql;

import java.util.List;

public class SqlBuilder {
    public static String buildQuery(Long id, String tableName, String idColumnName, List<String> tableColumns) {
        StringBuilder stlpce = new StringBuilder();
        for (String s: tableColumns) {
            stlpce.append(s).append(",");
        }
        String stlpceQuery = stlpce.toString().substring(0, stlpce.lastIndexOf(","));

        return String.format("SELECT %s FROM %s WHERE %s=%d", stlpceQuery, tableName, idColumnName, id);
    }
}
