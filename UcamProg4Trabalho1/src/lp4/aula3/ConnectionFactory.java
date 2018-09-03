package lp4.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection conexao() throws SQLException {		
		Connection conexao = 
				DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9255027", "sql9255027", "1AVXLJ7SBv");
//		System.out.println("conectado");
		return conexao;
	}
}
