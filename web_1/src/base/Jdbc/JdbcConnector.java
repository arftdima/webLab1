package base.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class JdbcConnector {
    private Connection conn;

    public Connection getConn() {

        return conn;
    }

    public JdbcConnector()
    {}

    public void getConnection() throws Exception {

        ResourceBundle resource = ResourceBundle.getBundle("base.resources.db");

        String url = resource.getString("url");
        String driver = resource.getString("driver");
        String user = resource.getString("user");
        String pass = resource.getString("password");

        Class.forName(driver);

        this.conn = DriverManager.getConnection(
                url, user, pass);

        return;
    }
    public void close() throws Exception {
        if (conn != null)
            conn.close();
    }
}

