package br.com.fiap.store.model.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

		private static ConnectionManager connectionManager;

		private ConnectionManager() {
		}

		public static ConnectionManager getInstance() {
			if (connectionManager == null) {
				connectionManager = new ConnectionManager();
			}
			return connectionManager;
		}

		public Connection getConnection() {
			Connection connection = null;
			try {

				Class.forName("oracle.jdbc.driver.OracleDriver");

				connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM95385",
						"230597");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}

	

	

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}

	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}


