package com.example.codex.model.bo;

import java.io.Serializable;
import java.util.Date;




public class DepartmentMaster implements Serializable {
	private Long idDept;
	private String businessUnit;
	private String active;
	private Long deptCreated_by;
	private Date deptCreated_at;
	private Date deptUpdated_by;
	private Date deptUpdated_at;

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Long getIdDept() {
		return idDept;
	}

	public void setIdDept(Long idDept) {
		this.idDept = idDept;
	}

	public Long getDeptCreated_by() {
		return deptCreated_by;
	}

	public void setDeptCreated_by(Long deptCreated_by) {
		this.deptCreated_by = deptCreated_by;
	}

	public Date getDeptCreated_at() {
		return deptCreated_at;
	}

	public void setDeptCreated_at(Date deptCreated_at) {
		this.deptCreated_at = deptCreated_at;
	}

	public Date getDeptUpdated_by() {
		return deptUpdated_by;
	}

	public void setDeptUpdated_by(Date deptUpdated_by) {
		this.deptUpdated_by = deptUpdated_by;
	}

	public Date getDeptUpdated_at() {
		return deptUpdated_at;
	}

	public void setDeptUpdated_at(Date deptUpdated_at) {
		this.deptUpdated_at = deptUpdated_at;
	}

}
