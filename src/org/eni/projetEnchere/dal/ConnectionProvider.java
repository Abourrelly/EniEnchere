package org.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
    private static DataSource dataSource;

    //bloc exécuter 1 seule fois lors du 1er appel de la classe (soit new, soit méthode ou variable static)
    static {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}