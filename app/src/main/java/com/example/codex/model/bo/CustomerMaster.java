package com.example.codex.model.bo;

import java.io.Serializable;

public class CustomerMaster implements Serializable {
	private Long idCustomer;
	private String custName;
	private String custAddress;
	private String custMobile;
	private String custStatus;

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
}
