package sk.michal.ormSimpleFramework.dbaccess;

import java.sql.ResultSet;

public class DataBaseAccess {
    public ResultSet executeQuery(String query) {
        return new ResultSetImpl();

    }

    public void insert(String query) {
        System.out.println(query);
    }
}