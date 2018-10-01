package br.edu.ucam.model.main;

import br.edu.ucam.model.dao.CidadeDAO;
import br.edu.ucam.model.dao.PaisDAO;
import br.edu.ucam.model.entities.Cidade;
import br.edu.ucam.model.entities.Pais;

public class Exercicio2Aula6 {

	public static final String STATE = "RJ";
	public static final String COUNTRY = "BR";
	public static final String COUNTRY_NAME ="Brazil";
	public static final String NAME = "Rio de Janeiro";

	/**
	 * Antes de rodar deve-se rodar os deletes abaixo
	 * 
	 * delete from person.StateProvince where StateProvinceCode = 'RJ'; delete from
	 * person.CountryRegion where CountryRegionCode = 'BR';
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CidadeDAO cidadeDAO = new CidadeDAO();
		PaisDAO paisDAO = new PaisDAO();
		
		Cidade cidadeRJ = cidadeDAO.buscarCodigoEstado(STATE);
		if (cidadeRJ != null) {
			throw new RuntimeException("Cidade " + STATE + " já existe. Não posso inserir novamente. Abortando!");
		}

		Cidade cidade = new Cidade();

		cidade.setStateProvinceCode(STATE);
		cidade.setCountryRegionCode(COUNTRY);
		cidade.setIsOnlyStateProvinceFlag(0);
		cidade.setName(NAME);
		cidade.setTerritoryID(2);

		Pais paisBR = paisDAO.buscarCodigoPais(COUNTRY);

		if (paisBR == null) {
			Pais pais = new Pais();
			pais.setCountryRegionCode(COUNTRY);
			pais.setName(COUNTRY_NAME);
			paisDAO.inserirPais(pais);
		}
		
		cidadeDAO.inserirCidade(cidade);

	}
}
