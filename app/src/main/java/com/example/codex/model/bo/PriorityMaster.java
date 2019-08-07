package com.example.codex.model.bo;

import java.io.Serializable;

public class PriorityMaster implements Serializable {
	private Long idPriority;
	private String priority;
	private String priorityCreated_by;
	private String priorityCreated_at;
	private String priorityUpdated_by;
	private String priorityUpdated_at;

	public Long getIdPriority() {
		return idPriority;
	}

	public void setIdPriority(Long idPriority) {
		this.idPriority = idPriority;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getPriorityCreated_by() {
		return priorityCreated_by;
	}

	public void setPriorityCreated_by(String priorityCreated_by) {
		this.priorityCreated_by = priorityCreated_by;
	}

	public String getPriorityCreated_at() {
		return priorityCreated_at;
	}

	public void setPriorityCreated_at(String priorityCreated_at) {
		this.priorityCreated_at = priorityCreated_at;
	}

	public String getPriorityUpdated_by() {
		return priorityUpdated_by;
	}

	public void setPriorityUpdated_by(String priorityUpdated_by) {
		this.priorityUpdated_by = priorityUpdated_by;
	}

	public String getPriorityUpdated_at() {
		return priorityUpdated_at;
	}

	public void setPriorityUpdated_at(String priorityUpdated_at) {
		this.priorityUpdated_at = priorityUpdated_at;
	}
}
