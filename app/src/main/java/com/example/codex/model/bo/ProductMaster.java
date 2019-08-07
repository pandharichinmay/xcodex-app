package com.example.codex.model.bo;

import java.io.Serializable;

public class ProductMaster implements Serializable {
	private Long idProdMaster;
	private String productApplication;
	private String productCreated_by;
	private Long productCreated_at;
	private Long productUpdated_by;
	private Long productUpdated_at;
	private Long productIdProdmaster;
	private String application_acronym;

	public Long getIdProdMaster() {
		return idProdMaster;
	}

	public void setIdProdMaster(Long idProdMaster) {
		this.idProdMaster = idProdMaster;
	}

	public String getProductApplication() {
		return productApplication;
	}

	public void setProductApplication(String productApplication) {
		this.productApplication = productApplication;
	}

	public String getProductCreated_by() {
		return productCreated_by;
	}

	public void setProductCreated_by(String productCreated_by) {
		this.productCreated_by = productCreated_by;
	}

	public Long getProductCreated_at() {
		return productCreated_at;
	}

	public void setProductCreated_at(Long productCreated_at) {
		this.productCreated_at = productCreated_at;
	}

	public Long getProductUpdated_by() {
		return productUpdated_by;
	}

	public void setProductUpdated_by(Long productUpdated_by) {
		this.productUpdated_by = productUpdated_by;
	}

	public Long getProductUpdated_at() {
		return productUpdated_at;
	}

	public void setProductUpdated_at(Long productUpdated_at) {
		this.productUpdated_at = productUpdated_at;
	}

	public Long getProductIdProdmaster() {
		return productIdProdmaster;
	}

	public void setProductIdProdmaster(Long productIdProdmaster) {
		this.productIdProdmaster = productIdProdmaster;
	}

	public String getApplication_acronym() {
		return application_acronym;
	}

	public void setApplication_acronym(String application_acronym) {
		this.application_acronym = application_acronym;
	}

}
