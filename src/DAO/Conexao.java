package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static String driver = "com.mysql.jdbc.Driver";
	private static Connection conexao = null;
	private static String url = "jdbc:mysql://localhost/eletronica";

	public static Connection conecta() {

		Connection connection = null;

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, "root", "root");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;

	}

}
