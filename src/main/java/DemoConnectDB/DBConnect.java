package DemoConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";

    public static final String DBNAME = "EMPDB";

    public static final String USERNAME = "sa";

    public static final String PASSWORD = "12345";

    public static Connection getConnection() {

        String connectionURL =
                "jdbc:sqlserver://"
                + HOSTNAME + ":" + PORT + ";"
                + "databaseName=" + DBNAME + ";"
                + "encrypt=true;"
                + "trustServerCertificate=true;";

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection conn = DriverManager.getConnection(
                    connectionURL,
                    USERNAME,
                    PASSWORD
            );

            return conn;

        } catch (ClassNotFoundException | SQLException ex) {

            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        Connection conn = getConnection();

        if (conn != null) {

            System.out.println("Kết nối thành công!");

        } else {

            System.out.println("Kết nối thất bại!");
        }
    }
}