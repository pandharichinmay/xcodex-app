package com.example.codex.model.bo;

import java.io.Serializable;

public class OrderHistoryLog implements Serializable {

	private Long idHistory;
	private OrderMaster ticketId;
	private UserMaster peopleId;
	private String histoydescription;
	private String comments;
	private String timestamp;

	public Long getIdHistory() {
		return idHistory;
	}

	public void setIdHistory(Long idHistory) {
		this.idHistory = idHistory;
	}

	public OrderMaster getTicketId() {
		return ticketId;
	}

	public void setTicketId(OrderMaster ticketId) {
		this.ticketId = ticketId;
	}

	public UserMaster getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(UserMaster peopleId) {
		this.peopleId = peopleId;
	}

	public String getHistoydescription() {
		return histoydescription;
	}

	public void setHistoydescription(String histoydescription) {
		this.histoydescription = histoydescription;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
