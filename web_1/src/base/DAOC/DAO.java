package base.DAOC;

import base.Jdbc.JdbcConnectionPool;
import base.Jdbc.JdbcConnector;

public class DAO {

    protected JdbcConnector cnr;
    protected JdbcConnectionPool cpr;

    public DAO() throws Exception {
            cnr = new JdbcConnector();
            cpr = new JdbcConnectionPool();
    }

    public JdbcConnector getJdbcConnector() {
        return cnr;
    }

    public JdbcConnectionPool JdbcConnectionPool() {
        return cpr;
    }
}



