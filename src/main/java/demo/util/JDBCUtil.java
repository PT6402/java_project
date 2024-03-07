package demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    String user = "sa";
    String password = "123";

    public Connection getConnection(String databaseName) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionString = "jdbc:sqlserver://localhost;databaseName=" + databaseName
                + ";TrustServerCertificate=True";
        Connection con = DriverManager.getConnection(connectionString, user, password);
        System.out.println("Connected to the database successfully!");
        return con;
    }
}
