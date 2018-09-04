package br.edu.ucam.model.entities;

import java.util.Date;

public class BusinessEntity {

	private int businessEntityId;
	private String rowguid;
	private Date modifiedDate;
	public int getBusinessEntityId() {
		return businessEntityId;
	}
	public void setBusinessEntityId(int businessEntityId) {
		this.businessEntityId = businessEntityId;
	}
	public String getRowguid() {
		return rowguid;
	}
	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "BusinessEntity [businessEntityId=" + businessEntityId + ", rowguid=" + rowguid + ", modifiedDate="
				+ modifiedDate + "]";
	}
	
	
}
