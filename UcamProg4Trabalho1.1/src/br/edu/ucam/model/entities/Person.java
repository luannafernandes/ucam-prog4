package br.edu.ucam.model.entities;

import java.util.Date;

public class Person {
	
	public static final String PERSON = "Person.Person";
	public static final String BUSINESSENTITYID = "BusinessEntityId";
	public static final String PERSONTYPE="PersonType";
	public static final String NAMESTYLE="NameStyle";
	public static final String TITLE = "Title";
	public static final String FIRSTNAME = "FirstName";
	public static final String MIDDLENAME = "MiddleName";
	public static final String LASTNAME = "LastName";
	public static final String SUFFIX = "Suffix";
	public static final String EMAILPROMOTION = "EmailPromotion";
	public static final String MODIFIEDDATE = "ModifiedDate";
	public static final String ROWGUID = "rowguid";
	
	private int businessEntityId;
	private String personType;
	private String nameStyle;
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private int emailPromotion;
	private Date modifiedDate;
	private String rowguid;
	
	public int getBusinessEntityId() {
		return businessEntityId;
	}
	public void setBusinessEntityId(int businessEntityId) {
		this.businessEntityId = businessEntityId;
	}
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	public String getNameStyle() {
		return nameStyle;
	}
	public void setNameStyle(String nameStyle) {
		this.nameStyle = nameStyle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public int getEmailPromotion() {
		return emailPromotion;
	}
	public void setEmailPromotion(int emailPromotion) {
		this.emailPromotion = emailPromotion;
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
		return "Person [businessEntityId=" + businessEntityId + ", personType=" + personType + ", nameStyle="
				+ nameStyle + ", title=" + title + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", suffix=" + suffix + ", emailPromotion=" + emailPromotion
				+ ", modifiedDate=" + modifiedDate + ", rowguid=" + rowguid + "]";
	}
	
	
}
