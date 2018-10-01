package br.edu.ucam.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import br.edu.ucam.model.entities.Cidade;
import br.edu.ucam.model.entities.Pais;

public class PaisDAO extends BaseDAO {

	public Pais buscarCodigoPais(String countryregioncode) {
		conectar();
		Vector<Pais> resultados = new Vector<Pais>();
		ResultSet rs;

		try {
			rs = comando.executeQuery(
					"SELECT * FROM " + Pais.PAIS + " where CountryRegionCode = '" + countryregioncode + "'");
			while (rs.next()) {
				Pais temp = new Pais();

				temp.setCountryRegionCode(rs.getString(Pais.COUNTRYREGIONCODE));
				temp.setName(rs.getString(Pais.NAME));
				temp.setModifiedDate(rs.getDate(Pais.MODIFIEDDATE));

				resultados.add(temp);
			}
			return (!resultados.isEmpty()) ? resultados.get(0) : null;
		} catch (SQLException e) {
			imprimeErro("Erro ao buscar pais " + countryregioncode, e);
			return null;
		}

	}
	

	
	public void inserirPais(Pais pais) {
		
		conectar();
		try {
			String sql = "INSERT INTO " + Pais.PAIS + " (CountryRegionCode, Name) VALUES('"
					+ pais.getCountryRegionCode() + "','"
					+ pais.getName() + "')";
			
			System.out.println(sql);
			comando.executeUpdate(sql);
			System.out.println("Inserido!");
		} catch (SQLException e) {
			imprimeErro("Erro ao inserir Person", e);
		} finally {
			fechar();
		}
	}
}