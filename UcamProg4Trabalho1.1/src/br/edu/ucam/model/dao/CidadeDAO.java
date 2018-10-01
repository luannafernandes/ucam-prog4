package br.edu.ucam.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import br.edu.ucam.model.entities.Cidade;
import br.edu.ucam.model.entities.Person;

public class CidadeDAO extends BaseDAO {

	public Cidade buscarCodigoEstado(String stateprovince) {
		conectar();
		Vector<Cidade> resultados = new Vector<Cidade>();
		ResultSet rs;

		try {
			rs = comando
					.executeQuery("SELECT * FROM " + Cidade.CIDADE + " where StateProvinceCode = '" + stateprovince + "'");
			while (rs.next()) {
				Cidade temp = new Cidade();

				temp.setStateProvinceID(rs.getInt(Cidade.STATEPROVINCEID));
				temp.setStateProvinceCode(rs.getString(Cidade.STATEPROVINCECODE));
				temp.setCountryRegionCode(rs.getString(Cidade.COUNTRYREGIONCODE));
				temp.setIsOnlyStateProvinceFlag(rs.getInt(Cidade.ISONLYSTATEPROVINCEFLAG));
				temp.setName(rs.getString(Cidade.NAME));
				temp.setTerritoryID(rs.getInt(Cidade.TERRITORYID));
				temp.setRowguid(rs.getString(Person.ROWGUID));
				temp.setModifiedDate(rs.getDate(Person.MODIFIEDDATE));

				resultados.add(temp);
			}
			return (!resultados.isEmpty()) ? resultados.get(0) : null;
		} catch (SQLException e) {
			imprimeErro("Erro ao buscar cidade " + stateprovince, e);
			return null;
		}

	}
	
	public void inserirCidade(Cidade cidade) {
		
		conectar();
		try {
			String sql = "INSERT INTO " + Cidade.CIDADE + " (StateProvinceCode, CountryRegionCode, IsOnlyStateProvinceFlag, Name, TerritoryID, rowguid) VALUES('"
					+ cidade.getStateProvinceCode() + "','" + cidade.getCountryRegionCode() + "','"
					+ cidade.getIsOnlyStateProvinceFlag()  + "','" + cidade.getName() + "','"
					+ cidade.getTerritoryID() + "', NEWID())";
			
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