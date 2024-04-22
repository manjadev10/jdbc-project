package net.demo.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {
	
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	
	public static Statement getStatement() {
		try {
			Class.forName("org.postgresql.Driver");
			Helper.connection = DriverManager.getConnection("jdbc:postgres://localhost/test_JDBC","postgres","pass123");
			Helper.statement = Helper.connection.createStatement();
			return Helper.statement;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			Class.forName("org.postgresql.Driver");
			Helper.connection = DriverManager.getConnection("jdbc:postgresql://localhost/test_JDBC","postgres","pass123");
			Helper.preparedStatement = Helper.connection.prepareStatement(sql);
			return Helper.preparedStatement;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void closeStatement() {
		try {
			Helper.statement.close();
			Helper.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void closePreparedStatement() {
		try {
			Helper.preparedStatement.close();
			Helper.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
