package lp4.aula3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class DaoAtor {
	
	   
	  
	   private Connection con;  
	   private Statement comando;  
	  
	   public void apagar(int id_ator) {  
	      conectar();  
	      try {  
	         comando  
	               .executeUpdate("DELETE FROM ator WHERE id_ator = " + id_ator  
	                     + ";");  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao apagar atores", e.getMessage());  
	      } finally {  
	         fechar();  
	      }  
	   }  
	  
	   public Vector<Ator> buscarTodos() {  
	      conectar();  
	      Vector<Ator> resultados = new Vector<Ator>();  
	      ResultSet rs;  
	      try {  
	         rs = comando.executeQuery("SELECT * FROM ator");  
	         while (rs.next()) {  
	            Ator temp = new Ator();  
	            // pega os atributos do Ator  
	            temp.setId(rs.getInt("id_ator"));  
	            temp.setNome(rs.getString("nome"));  
	            temp.setSobrenome(rs.getString("sobrenome"));  	              
	            resultados.add(temp);  
	         }  
	         return resultados;  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao buscar atores", e.getMessage());  
	         return null;  
	      }  
	   }  
	  
	   public void atualizar(Ator ator) {  
	      conectar();  
	      String com = "UPDATE ator SET nome = '" + ator.getNome()  
	            + "', sobrenome = '" + ator.getSobrenome() + "';";
	      System.out.println("Atualizado!");  
	      try {  
	         comando.executeUpdate(com);  
	      } catch (SQLException e) {  
	         e.printStackTrace();  
	      } finally {  
	         fechar();  
	      }  
	   }  
	  
	   public Vector<Ator> buscar(int id_ator) {  
	      conectar();  
	      Vector<Ator> resultados = new Vector<Ator>();  
	      ResultSet rs;  
	      try {  
	         rs = comando.executeQuery("SELECT * FROM ator WHERE id_ator ="  
	               + id_ator + ";");  
	         while (rs.next()) {  
	            Ator temp = new Ator();  
	            // pega os atributos do ator  
	            temp.setId(rs.getInt("id_ator"));  
	            temp.setNome(rs.getString("nome"));  
	            temp.setSobrenome(rs.getString("sobrenome"));   
	            resultados.add(temp);  
	         }  
	         return resultados;  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao buscar ator", e.getMessage());  
	         return null;  
	      }  
	  
	   }  
	  
	   public void insere(Ator ator){  
	      conectar();  
	      try {  
	         comando.executeUpdate("INSERT INTO ator (nome, sobrenome) VALUES('"  
	               + ator.getNome() + "','" + ator.getSobrenome() + "')");  
	         System.out.println("Inserido!");  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao inserir Ator", e.getMessage());  
	      } finally {  
	         fechar();  
	      }  
	   }  
	  
	   private void conectar() {  
	      try {  
	         con = ConnectionFactory.conexao();  
	         comando = con.createStatement();  
	         System.out.println("Conectado!");  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao conectar", e.getMessage());  
	      }  
	   }  
	  
	   private void fechar() {  
	      try {  
	         comando.close();  
	         con.close();  
	         System.out.println("Conexao Fechada");  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao fechar conexao", e.getMessage());  
	      }  
	   }  
	  
	   private void imprimeErro(String msg, String msgErro) {  
//	      JOptionPane.showMessageDialog(null, msg, "Erro cr�tico", 0);  
	      System.err.println(msg + " " + msgErro);  
//	      System.out.println(msgErro);  
//	      System.exit(0);  
	   }  

}
