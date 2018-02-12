package base.DAOC;

import base.Jdbc.JdbcConnector;

public class DAO {

    protected JdbcConnector cnr;

    public DAO() throws Exception {
            cnr = new JdbcConnector();
    }

    public JdbcConnector getJdbcConnector() {

        return cnr;
    }
}



