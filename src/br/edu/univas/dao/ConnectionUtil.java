package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static final String USER = "postgres";
	private static final String PASSWORD = "123456";
	
	public static Connection getConnection() {
		Connection connection = null;
		String url = "jdbc:postgresql://localhost/estacionamento";
		
		Properties properties = new Properties();
		properties.setProperty("user", USER);
		properties.setProperty("password", PASSWORD);
		try {
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			System.out.print("Erro ao conectar ao banco de dados!");
			e.printStackTrace();
		}
		
		return connection;
	}
}
