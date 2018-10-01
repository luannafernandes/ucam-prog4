package br.edu.ucam.model.entities;

import java.util.Date;

public class Pais {
	
	public static final String PAIS = "Person.CountryRegion";
	public static final String COUNTRYREGIONCODE = "CountryRegionCode";
	public static final String NAME = "Name";
	public static final String MODIFIEDDATE = "ModifiedDate";

	private String countryRegionCode;
	private String name;
	private Date modifiedDate;
	
	
	public String getCountryRegionCode() {
		return countryRegionCode;
	}
	public void setCountryRegionCode(String countryRegionCode) {
		this.countryRegionCode = countryRegionCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "Pais [countryRegionCode=" + countryRegionCode + ", name=" + name + ", modifiedDate=" + modifiedDate
				+ "]";
	}

}
