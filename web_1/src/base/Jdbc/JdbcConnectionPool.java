package base.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JdbcConnectionPool {
    public JdbcConnectionPool() throws Exception {
        ResourceBundle resource = ResourceBundle.getBundle("base.resources.db");

        String url = resource.getString("url");
        String driver = resource.getString("driver");
        String user = resource.getString("user");
        String pass = resource.getString("password");
        maxNumberConnections = Integer.parseInt(resource.getString("max_number_of_connections"));

        Class.forName(driver);

        ConnectionQueue = new ConcurrentLinkedQueue<Connection>();
        semaphore = new Semaphore(maxNumberConnections,true);
        for (int i = 0; i < maxNumberConnections; ++i)
            ConnectionQueue.add(DriverManager.getConnection(url, user, pass));
    }

    private Integer maxNumberConnections;
    private ConcurrentLinkedQueue<Connection> ConnectionQueue;
    private Semaphore semaphore;

    public synchronized Connection getConnection() throws Exception {
        semaphore.acquire();
        Connection c = ConnectionQueue.poll();
        return c;
    }

    public synchronized void closeConnectin(Connection conn) throws Exception{
        ConnectionQueue.add(conn);
        semaphore.release();
    }


}

