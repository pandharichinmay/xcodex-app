package com.example.codex.model.bo;

import java.io.Serializable;

public class OrderTypeMaster implements Serializable {
	private Long idOrdertype;
	private String type;
	private String orderTypeDescription;

	public Long getIdOrdertype() {
		return idOrdertype;
	}

	public void setIdOrdertype(Long idOrdertype) {
		this.idOrdertype = idOrdertype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrderTypeDescription() {
		return orderTypeDescription;
	}

	public void setOrderTypeDescription(String orderTypeDescription) {
		this.orderTypeDescription = orderTypeDescription;
	}

}
