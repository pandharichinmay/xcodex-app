package com.example.codex.model.bo;

import java.io.Serializable;
import java.util.Date;

public class OrderStatusMaster implements Serializable {
	private Long idOrderstatus;
	private String status;
	private Long sequence_id;
	private Long orderstatuscreated_by;
	private Date orderstatuscreated_at;
	private Date orderstatusupdated_by;
	private Date orderstatusupdated_at;

	public Long getIdOrderstatus() {
		return idOrderstatus;
	}

	public void setIdOrderstatus(Long idOrderstatus) {
		this.idOrderstatus = idOrderstatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSequence_id() {
		return sequence_id;
	}

	public void setSequence_id(Long sequence_id) {
		this.sequence_id = sequence_id;
	}

	public Long getOrderstatuscreated_by() {
		return orderstatuscreated_by;
	}

	public void setOrderstatuscreated_by(Long orderstatuscreated_by) {
		this.orderstatuscreated_by = orderstatuscreated_by;
	}

	public Date getOrderstatuscreated_at() {
		return orderstatuscreated_at;
	}

	public void setOrderstatuscreated_at(Date orderstatuscreated_at) {
		this.orderstatuscreated_at = orderstatuscreated_at;
	}

	public Date getOrderstatusupdated_by() {
		return orderstatusupdated_by;
	}

	public void setOrderstatusupdated_by(Date orderstatusupdated_by) {
		this.orderstatusupdated_by = orderstatusupdated_by;
	}

	public Date getOrderstatusupdated_at() {
		return orderstatusupdated_at;
	}

	public void setOrderstatusupdated_at(Date orderstatusupdated_at) {
		this.orderstatusupdated_at = orderstatusupdated_at;
	}

}
