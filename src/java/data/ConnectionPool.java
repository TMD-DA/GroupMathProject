package data;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    private static final Logger LOG = Logger.getLogger(ConnectionPool.class.getName());

    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/useraccount_db"); //This will need to change pulled this from an old file just to have something in this folder so it hits github. Everything else should be alright in this file though.
        } catch (NamingException e) {
            LOG.log(Level.SEVERE, "*** data source lookup fail", e);
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** get connection from datasource fail", e);

            return null;
        }
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** freeing connection fail", e);
        }
    }
}
