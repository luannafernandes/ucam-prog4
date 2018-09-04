package br.edu.ucam.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import br.edu.ucam.model.entities.BusinessEntity;
import br.edu.ucam.model.entities.Person;
import br.edu.ucam.model.util.ConnectionFactory;

public class PersonDAO {

	private Connection con;
	private Statement comando;
	
	public Vector<Person> buscarPorNomeESobrenome(String nome, String sobrenome) {
		conectar();
		Vector<Person> resultados = new Vector<Person>();
		ResultSet rs;
		try {
			rs = comando.executeQuery("SELECT * FROM " + Person.PERSON + " where FirstName = '" + nome + "' and LastName = '" + sobrenome + "';");
			while (rs.next()) {
				Person temp = new Person();

				temp.setBusinessEntityId(rs.getInt(Person.BUSINESSENTITYID));
				temp.setPersonType(rs.getString(Person.PERSONTYPE));
				temp.setNameStyle(rs.getString(Person.NAMESTYLE));
				temp.setTitle(rs.getString(Person.TITLE));
				temp.setFirstName(rs.getString(Person.FIRSTNAME));
				temp.setMiddleName(rs.getString(Person.MIDDLENAME));
				temp.setLastName(rs.getString(Person.LASTNAME));
				temp.setSuffix(rs.getString(Person.SUFFIX));
				temp.setEmailPromotion(rs.getInt(Person.EMAILPROMOTION));
				temp.setRowguid(rs.getString(Person.ROWGUID));
				temp.setModifiedDate(rs.getDate(Person.MODIFIEDDATE));

				resultados.add(temp);
			}
			return resultados;
		} catch (SQLException e) {
			imprimeErro("Erro ao buscar pessoa nome "+ nome + " - sobrenome " + sobrenome + ".", e);
			return null;
		}
	}

	public Vector<Person> buscarTodos() {
		conectar();
		Vector<Person> resultados = new Vector<Person>();
		ResultSet rs;
		try {
			rs = comando.executeQuery("SELECT * FROM " + Person.PERSON);
			while (rs.next()) {
				Person temp = new Person();

				temp.setBusinessEntityId(rs.getInt(Person.BUSINESSENTITYID));
				temp.setPersonType(rs.getString(Person.PERSONTYPE));
				temp.setNameStyle(rs.getString(Person.NAMESTYLE));
				temp.setTitle(rs.getString(Person.TITLE));
				temp.setFirstName(rs.getString(Person.FIRSTNAME));
				temp.setMiddleName(rs.getString(Person.MIDDLENAME));
				temp.setLastName(rs.getString(Person.LASTNAME));
				temp.setSuffix(rs.getString(Person.SUFFIX));
				temp.setEmailPromotion(rs.getInt(Person.EMAILPROMOTION));
				temp.setRowguid(rs.getString(Person.ROWGUID));
				temp.setModifiedDate(rs.getDate(Person.MODIFIEDDATE));

				resultados.add(temp);
			}
			return resultados;
		} catch (SQLException e) {
			imprimeErro("Erro ao buscar pessoas", e);
			return null;
		}
	}

	private void conectar() {
		try {
			con = ConnectionFactory.conexao();
			comando = con.createStatement();
			System.out.println("Conectado!");
		} catch (SQLException e) {
			imprimeErro("Erro ao conectar", e);
		}
	}

	private void fechar() {
		try {
			comando.close();
			con.close();
			System.out.println("Conexao Fechada");
		} catch (SQLException e) {
			imprimeErro("Erro ao fechar conexao", e);
		}
	}

	private void imprimeErro(String msg, Throwable e) {
		// JOptionPane.showMessageDialog(null, msg, "Erro cr�tico", 0);
		System.err.println(msg + " " + e.getMessage());
		e.printStackTrace();
		// System.out.println(msgErro);
		// System.exit(0);
	}

	public void insere(Person person) {
		
		BusinessEntity businessEntity = insereBusinessEntity();
		
		conectar();
		try {
			String sql = "INSERT INTO Person.Person (BusinessEntityId, PersonType, NameStyle, Title, FirstName, MiddleName, LastName, EmailPromotion, rowguid, ModifiedDate) VALUES('"
					+ businessEntity.getBusinessEntityId() + "','" + person.getPersonType() + "','" + person.getNameStyle() + "','" + person.getTitle() + "','"
					+ person.getFirstName() + "','" + person.getMiddleName() + "','" + person.getLastName() + "','"
					+ person.getEmailPromotion() + "','" + businessEntity.getRowguid() + "','" + businessEntity.getModifiedDate() + "')";
			System.out.println(sql);
			comando.executeUpdate(sql);
			System.out.println("Inserido!");
		} catch (SQLException e) {
			imprimeErro("Erro ao inserir Person", e);
		} finally {
			fechar();
		}
	}

	private BusinessEntity insereBusinessEntity() {
		BusinessEntity businessEntity = null;
		ResultSet rs = null;
		conectar();
		try {
			String sql = "INSERT INTO Person.BusinessEntity (rowguid) VALUES (default);";
			comando.executeUpdate(sql);
			System.out.println("Inserido!");
			
			rs = comando.executeQuery("select * from Person.BusinessEntity where BusinessEntityId = ( select max(BusinessEntityId) from Person.BusinessEntity );");
			while (rs.next()) {
				businessEntity = new BusinessEntity();
				businessEntity.setBusinessEntityId(rs.getInt("BusinessEntityId"));
				businessEntity.setRowguid(rs.getString("Rowguid"));
				businessEntity.setModifiedDate(rs.getDate("ModifiedDate"));
			}
		} catch (SQLException e) {
			imprimeErro("Erro ao inserir BusinessEntity", e);
		} finally {
			fechar();
		}
		
		return businessEntity;
	}
	
	public void apagar(int businessEntityId) {  
	      conectar();  
	      try {  
	         comando.executeUpdate("DELETE FROM Person.Person WHERE BusinessEntityId = " + businessEntityId  + ";");  
	         comando.executeUpdate("DELETE FROM Person.BusinessEntity WHERE BusinessEntityId = " + businessEntityId  + ";");  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao apagar person", e);  
	      } finally {  
	         fechar();  
	      }  
	   }  
}
