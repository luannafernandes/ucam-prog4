package br.edu.ucam.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ucam.model.util.ConnectionFactory;

public class BaseDAO {

	protected Connection con;
	protected Statement comando;

	protected void conectar() {
		try {
			con = ConnectionFactory.conexao();
			comando = con.createStatement();
			System.out.println("Conectado!");
		} catch (SQLException e) {
			imprimeErro("Erro ao conectar", e);
		}
	}

	protected void fechar() {
		try {
			comando.close();
			con.close();
			System.out.println("Conexao Fechada");
		} catch (SQLException e) {
			imprimeErro("Erro ao fechar conexao", e);
		}
	}

	protected void imprimeErro(String msg, Throwable e) {
		// JOptionPane.showMessageDialog(null, msg, "Erro cr�tico", 0);
		System.err.println(msg + " " + e.getMessage());
		e.printStackTrace();
		// System.out.println(msgErro);
		// System.exit(0);
	}

}
