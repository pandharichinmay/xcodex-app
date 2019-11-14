package com.example.codex.model.bo;

import java.io.Serializable;
import java.util.Date;

public class OrderHistoryLog implements Serializable {

    private Long idHistory;
    private OrderMaster ticketId;
    private UserMaster peopleId;
    private String histoydescription;
    private String comments;
    private Date timestamp;

    private UserMaster oldUser;
    private UserMaster newUser;
    private OrderStatusMaster oldStatus;
    private OrderStatusMaster newStatus;
    private Integer timeLapsed;

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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public UserMaster getOldUser() {
        return oldUser;
    }

    public void setOldUser(UserMaster oldUser) {
        this.oldUser = oldUser;
    }

    public UserMaster getNewUser() {
        return newUser;
    }

    public void setNewUser(UserMaster newUser) {
        this.newUser = newUser;
    }

    public OrderStatusMaster getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(OrderStatusMaster oldStatus) {
        this.oldStatus = oldStatus;
    }

    public OrderStatusMaster getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(OrderStatusMaster newStatus) {
        this.newStatus = newStatus;
    }

    public Integer getTimeLapsed() {
        return timeLapsed;
    }

    public void setTimeLapsed(Integer timeLapsed) {
        this.timeLapsed = timeLapsed;
    }
}
