package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection con;

	public Connection getConnection() {
		return this.con;
	}

	public Conexao() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seminario", "root", "root");
			System.out.println("Conectado!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
