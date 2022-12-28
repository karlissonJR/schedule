package com.karlisson.dbconnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

public class MysqlConnection extends HttpServlet {

	private static Connection conn = null;
	
	public static Connection getConnection(InputStream stream) {

		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Properties props = MysqlConnection.loadProperties(stream);
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static Connection getConnection() {
		return conn;
	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Properties loadProperties(InputStream stream) {
		try {
			Properties props = new Properties();
			props.load(stream);
			return props;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}