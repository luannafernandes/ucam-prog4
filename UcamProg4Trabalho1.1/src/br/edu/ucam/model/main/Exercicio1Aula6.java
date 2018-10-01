package br.edu.ucam.model.main;

import br.edu.ucam.model.dao.CidadeDAO;
import br.edu.ucam.model.dao.PaisDAO;
import br.edu.ucam.model.entities.Cidade;
import br.edu.ucam.model.entities.Pais;

public class Exercicio1Aula6 {
	
	
	public static void main(String[] args) {
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		PaisDAO paisDAO = new PaisDAO();
		
		Cidade cidade = cidadeDAO.buscarCodigoEstado("NY");
		System.out.println(cidade);
	
		
		Pais pais = paisDAO.buscarCodigoPais("US");
		System.out.println(pais);
	}
}
