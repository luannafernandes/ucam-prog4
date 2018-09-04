package br.edu.ucam.model.main;

import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import br.edu.ucam.model.dao.PersonDAO;
import br.edu.ucam.model.entities.Person;

public class Main {
	
	private static final String NOME = "LUANNA";
	private static final String SOBRENOME = "LIMA";

	private static final String NOME2 = "ELAINE";
	private static final String SOBRENOME2 = "DA SILVA";

	public static void main(String[] args) throws SQLException {
		
		Person person = new Person();
		person.setNameStyle("0");
		person.setTitle(null);
		person.setPersonType("IN");
		person.setFirstName(NOME);
		person.setMiddleName("F");
		person.setLastName(SOBRENOME);
		person.setEmailPromotion(0);
		
		PersonDAO personDAO = new PersonDAO();

		System.out.println("INICIO");

		//busca todos
		Vector<Person> listaPerson = personDAO.buscarTodos();
		
		assert( listaPerson.size() == 19972 ) : "banco deveria estar preenchido";
		
		listaPerson.forEach( System.out::println );
		
		//insere pessoa
		personDAO.insere(person);
		
		//recupera a pessoa inserida anteriormente
		listaPerson = personDAO.buscarPorNomeESobrenome(NOME, SOBRENOME);
		person = listaPerson.get(0);

		//verifica nome e sobrenome
		assert( person.getFirstName().equalsIgnoreCase( NOME ) ): "Nome nao confere com o nome armazenado";   
		assert( person.getLastName().equalsIgnoreCase( SOBRENOME ) ): "Sobrenome nao confere com o nome armazenado";   

		//apaga pessoa inserida anteriormente
		personDAO.apagar( person.getBusinessEntityId() );
		
		//busca todo mundo novamente
		listaPerson = personDAO.buscarTodos();
		
		//verifica se o banco contem o mesmo numero do inicio
		assert( listaPerson.size() == 19972 ) : "banco deveria estar preenchido";
		
		System.out.println("FIM");
		
	}
}
