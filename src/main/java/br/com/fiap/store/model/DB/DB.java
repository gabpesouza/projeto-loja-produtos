package br.com.fiap.store.model.DB;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import br.com.fiap.store.model.DB.exceptions.DbException;

public class DB {
	
	private static Connection con = null;

	public static Properties loadProperties() {
		try {
			FileInputStream fis = new FileInputStream("db.properties");
			Properties props = new Properties();
			props.load(fis);
			return props;

		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}

	}

	public static Connection getConnection() throws ClassNotFoundException {

		if (con == null) {

			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");  

				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				con = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}

		return con;

	}

	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

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


