package com.example.codex.model.php;

import java.io.Serializable;
import java.util.List;

public class UpdateOrderRequest implements Serializable {

    private Long id;
    private String title;
    private Long customer_id;
    private Long departmentid;
    private Long ticket_type;
    private Long category;
    private List<Long> productsList;
    private String submitter_id;
    private Long assign_to;
    private Long priority;
    private Long status;
    private String start_date;
    private String due_date;
    private String closure_code;
    private String end_date;
    private String username;
    private Long userid;
    private List<Integer> productQuantity;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Long departmentid) {
        this.departmentid = departmentid;
    }

    public Long getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(Long ticket_type) {
        this.ticket_type = ticket_type;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public List<Long> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Long> productsList) {
        this.productsList = productsList;
    }

    public String getSubmitter_id() {
        return submitter_id;
    }

    public void setSubmitter_id(String submitter_id) {
        this.submitter_id = submitter_id;
    }

    public Long getAssign_to() {
        return assign_to;
    }

    public void setAssign_to(Long assign_to) {
        this.assign_to = assign_to;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getClosure_code() {
        return closure_code;
    }

    public void setClosure_code(String closure_code) {
        this.closure_code = closure_code;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
