package org.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class ConnectionProvider {
    private static DataSource dataSource;

    //bloc exécuter 1 seule fois lors du 1er appel de la classe (soit new, soit méthode ou variable static)
//    static {
//        try {
//            Context context = new InitialContext();
//            dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Connection getConnection() throws SQLException {
//        return dataSource.getConnection();
//    }
    
	public static Connection getConnection() {
		
		Connection con = null;
		
		//Etape 1 - Charger le driver jdbc
		try {
			
			DriverManager.registerDriver(new SQLServerDriver());
			
			//Etape 2 - Connection
			String url = "jdbc:sqlserver://benjamin-it.com:1433;databasename=ENI_DATA";
			
			con = DriverManager.getConnection(url, "sa", "P@ssword35");
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		return con;

	}
}