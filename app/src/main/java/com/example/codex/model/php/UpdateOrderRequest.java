package com.example.codex.model.php;

import java.io.Serializable;
import java.util.List;

public class UpdateOrderRequest implements Serializable {


    private String title;
    private Integer customer_id;
    private Integer departmentid;
    private Integer ticket_type;
    private Integer category;
    private List<Integer> productsList;
    private String submitter_id;
    private Integer assign_to;
    private Integer priority;
    private Integer status;
    private String startDate;
    private String dueDate;
    private String closureCode;
    private String endDate;
    private String username;
    private Long userid;
    private List<Integer> productQuantity;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(Integer ticket_type) {
        this.ticket_type = ticket_type;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public List<Integer> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Integer> productsList) {
        this.productsList = productsList;
    }

    public String getSubmitter_id() {
        return submitter_id;
    }

    public void setSubmitter_id(String submitter_id) {
        this.submitter_id = submitter_id;
    }

    public Integer getAssign_to() {
        return assign_to;
    }

    public void setAssign_to(Integer assign_to) {
        this.assign_to = assign_to;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getClosureCode() {
        return closureCode;
    }

    public void setClosureCode(String closureCode) {
        this.closureCode = closureCode;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public List<Integer> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(List<Integer> productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }
}
