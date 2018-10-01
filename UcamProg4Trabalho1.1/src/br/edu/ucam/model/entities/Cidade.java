package br.edu.ucam.model.entities;

import java.util.Date;
public class Cidade {
	
	public static final String CIDADE = "Person.StateProvince";
	public static final String STATEPROVINCEID = "StateProvinceID";
	public static final String STATEPROVINCECODE="StateProvinceCode";
	public static final String COUNTRYREGIONCODE="CountryRegionCode";
	public static final String ISONLYSTATEPROVINCEFLAG = "IsOnlyStateProvinceFlag";
	public static final String NAME = "Name";
	public static final String TERRITORYID = "TerritoryID";
	public static final String MODIFIEDDATE = "ModifiedDate";
	public static final String ROWGUID = "rowguid";
	
//	StateProvinceID	int
//	StateProvinceCode	nchar
//	CountryRegionCode	nvarchar
//	IsOnlyStateProvinceFlag	bit
//	Name	nvarchar
//	TerritoryID	int
//	rowguid	uniqueidentifier
//	ModifiedDate	datetime
	private int stateProvinceID;
	private String stateProvinceCode;
	private String countryRegionCode;
	private int isOnlyStateProvinceFlag;
	private String name;
	private int territoryID;
	private Date modifiedDate;
	private String rowguid;
	
	private Pais pais;
	
	public int getStateProvinceID() {
		return stateProvinceID;
	}
	public void setStateProvinceID(int stateProvinceID) {
		this.stateProvinceID = stateProvinceID;
	}
	public String getStateProvinceCode() {
		return stateProvinceCode;
	}
	public void setStateProvinceCode(String stateProvinceCode) {
		this.stateProvinceCode = stateProvinceCode;
	}
	public String getCountryRegionCode() {
		return countryRegionCode;
	}
	public void setCountryRegionCode(String countryRegionCode) {
		this.countryRegionCode = countryRegionCode;
	}
	public int getIsOnlyStateProvinceFlag() {
		return isOnlyStateProvinceFlag;
	}
	public void setIsOnlyStateProvinceFlag(int isOnlyStateProvinceFlag) {
		this.isOnlyStateProvinceFlag = isOnlyStateProvinceFlag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTerritoryID() {
		return territoryID;
	}
	public void setTerritoryID(int territoryID) {
		this.territoryID = territoryID;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getRowguid() {
		return rowguid;
	}
	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}
	@Override
	public String toString() {
		return "Cidade [stateProvinceID=" + stateProvinceID + ", stateProvinceCode=" + stateProvinceCode
				+ ", countryRegionCode=" + countryRegionCode + ", isOnlyStateProvinceFlag=" + isOnlyStateProvinceFlag
				+ ", name=" + name + ", territoryID=" + territoryID + ", modifiedDate=" + modifiedDate + ", rowguid="
				+ rowguid + "]";
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}



	

