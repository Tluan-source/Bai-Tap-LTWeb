package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConn {
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=web;encrypt=false;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASS = "270405";

    public static Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
