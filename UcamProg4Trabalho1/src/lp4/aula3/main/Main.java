package lp4.aula3.main;

import java.util.Vector;

import lp4.aula3.Ator;
import lp4.aula3.DaoAtor;

public class Main {
	
	private static final String NOME = "LUANNA";
	private static final String SOBRENOME = "LIMA";

	private static final String NOME2 = "ELAINE";
	private static final String SOBRENOME2 = "DA SILVA";

	public static void main(String[] args) {
		
		System.out.print("Iniciando ...");
		
		Ator ator = new Ator();
		ator.setNome( NOME );
		ator.setSobrenome( SOBRENOME );
		
		DaoAtor daoAtor = new DaoAtor();
		
		Vector<Ator> listaAtor = daoAtor.buscarTodos();
		
		assert( listaAtor.size() == 0 ) : "banco deveria estar vazio";
		
		daoAtor.insere(ator);
		
		listaAtor = daoAtor.buscarTodos();
		
		assert( listaAtor.size() == 1 ) : "banco deveria ter 1 elemento";
		
		ator = listaAtor.get(0);
		
		assert( ator.getNome().equalsIgnoreCase( NOME ) ): "Nome nao confere com o nome armazenado";   
		assert( ator.getSobrenome().equalsIgnoreCase( SOBRENOME ) ): "Sobrenome nao confere com o nome armazenado";   
		
		ator.setNome(NOME2);
		ator.setSobrenome(SOBRENOME2);
		daoAtor.atualizar(ator);

		listaAtor = daoAtor.buscarTodos();
		
		ator = listaAtor.get(0);
		assert( ator.getNome().equalsIgnoreCase( NOME2 ) ): "Nome nao confere com o nome armazenado";   
		assert( ator.getSobrenome().equalsIgnoreCase( SOBRENOME2 ) ): "Sobrenome nao confere com o nome armazenado";   
		
		
		daoAtor.apagar( ator.getId() );
		
		listaAtor = daoAtor.buscarTodos();
		
		assert( listaAtor.size() == 0 ) : "banco deveria estar vazio";
         
		
	}
}
