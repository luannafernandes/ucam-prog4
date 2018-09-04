package br.edu.ucam.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection conexao() throws SQLException {		
		Connection conexao = 
				DriverManager.getConnection("jdbc:sqlserver://lgfernandeslima.database.windows.net:1433;database=AdventureWorks2014;user=lgfernandeslima@lgfernandeslima;password=Extreme907;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", "lgfernandeslima@lgfernandeslima", "Extreme907");
//		System.out.println("conectado");
		return conexao;
	}
}
