package com.example.codex.model.bo;

import java.io.Serializable;

public class OrderReplies implements Serializable {
	private Long idOrderrpl;
	private Long rplTicketid;
	private Long peopleid;
	private String message;
	private String replyTimestamp;

	public Long getIdOrderrpl() {
		return idOrderrpl;
	}

	public void setIdOrderrpl(Long idOrderrpl) {
		this.idOrderrpl = idOrderrpl;
	}

	public Long getRplTicketid() {
		return rplTicketid;
	}

	public void setRplTicketid(Long rplTicketid) {
		this.rplTicketid = rplTicketid;
	}

	public Long getPeopleid() {
		return peopleid;
	}

	public void setPeopleid(Long peopleid) {
		this.peopleid = peopleid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReplyTimestamp() {
		return replyTimestamp;
	}

	public void setReplyTimestamp(String replyTimestamp) {
		this.replyTimestamp = replyTimestamp;
	}
}
