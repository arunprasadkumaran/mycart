/**
 * 
 */
package com.org.sample.goal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author arun.prasad
 *
 */
public class DerbyDataConnectionTest {

	/**
	 * user=sysdba;password=masterkey
	 */

	private static String dbURL = "jdbc:derby://localhost:1527/D:\\Database\\Derby\\cart;";
	private static String createTable = "CREATE TABLE CUSTOMER (EMAIL_ID VARCHAR(100) PRIMARY KEY, NAME VARCHAR(50),PASSWORD VARCHAR(10));";
	// jdbc Connection
	private static Connection conn = null;
	private static Statement stmt = null;

	public static void main(String[] args) {
		createConnection();
		try {
			System.out.println(isValidUser("Arun Prasad", "test"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		shutdown();
	}

	private static void createConnection() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			// Get a connection
			conn = DriverManager.getConnection(dbURL+"create=true;");
		} catch (Exception except) {
			except.printStackTrace();
		}
	}
	
	public static boolean isValidUser(String username, String password) throws SQLException {
		String query = "Select count(1) from CUSTOMER where NAME = ? and password = ?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return (resultSet.getInt(1) > 0);
		else
			return false;
	}

	private static void shutdown() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				DriverManager.getConnection(dbURL + ";shutdown=true");
				conn.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}

}
