package com.example.codex.model.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class OrderMaster implements Serializable {
	private Long idOrder;
	private UserMaster orderCreated_by;
	private PriorityMaster priority_id;
	private CategoryMaster category_id;
	private OrderStatusMaster status_id;
	private Date start_date;
	private Date orderCreated_at;
	private UserMaster orderUpdated_by;
	private Date updatedDate;
	private Date due_date;
	private Date end_date;
	private UserMaster assignedTo;
	private String title;
	private Long requester_id;
	private String tracking_number;
	private DepartmentMaster departmentid;
	private Long adminid;
	private String ccs;
	private String closure_code;
	private String ticket_type;
	private String impacted_applications;
	private String ticket_closed_date;
	private UserMaster ticket_closed_by;
	private String active_flag;
	private CustomerMaster customer_id;
	private List<OrderProductMapping> products;
	
	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public UserMaster getOrderCreated_by() {
		return orderCreated_by;
	}

	public void setOrderCreated_by(UserMaster orderCreated_by) {
		this.orderCreated_by = orderCreated_by;
	}

	public PriorityMaster getPriority_id() {
		return priority_id;
	}

	public void setPriority_id(PriorityMaster priority_id) {
		this.priority_id = priority_id;
	}

	public CategoryMaster getCategory_id() {
		return category_id;
	}

	public void setCategory_id(CategoryMaster category_id) {
		this.category_id = category_id;
	}

	public OrderStatusMaster getStatus_id() {
		return status_id;
	}

	public void setStatus_id(OrderStatusMaster status_id) {
		this.status_id = status_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getOrderCreated_at() {
		return orderCreated_at;
	}

	public void setOrderCreated_at(Date orderCreated_at) {
		this.orderCreated_at = orderCreated_at;
	}

	public UserMaster getOrderUpdated_by() {
		return orderUpdated_by;
	}

	public void setOrderUpdated_by(UserMaster orderUpdated_by) {
		this.orderUpdated_by = orderUpdated_by;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date date) {
		this.updatedDate = date;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public UserMaster getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(UserMaster assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getRequester_id() {
		return requester_id;
	}

	public void setRequester_id(Long requester_id) {
		this.requester_id = requester_id;
	}

	public String getTracking_number() {
		return tracking_number;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}

	public DepartmentMaster getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(DepartmentMaster departmentid) {
		this.departmentid = departmentid;
	}

	public Long getAdminid() {
		return adminid;
	}

	public void setAdminid(Long adminid) {
		this.adminid = adminid;
	}

	public String getCcs() {
		return ccs;
	}

	public void setCcs(String ccs) {
		this.ccs = ccs;
	}

	public String getClosure_code() {
		return closure_code;
	}

	public void setClosure_code(String closure_code) {
		this.closure_code = closure_code;
	}

	public String getTicket_type() {
		return ticket_type;
	}

	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}

	public String getImpacted_applications() {
		return impacted_applications;
	}

	public void setImpacted_applications(String impacted_applications) {
		this.impacted_applications = impacted_applications;
	}

	public String getTicket_closed_date() {
		return ticket_closed_date;
	}

	public void setTicket_closed_date(String ticket_closed_date) {
		this.ticket_closed_date = ticket_closed_date;
	}

	public UserMaster getTicket_closed_by() {
		return ticket_closed_by;
	}

	public void setTicket_closed_by(UserMaster ticket_closed_by) {
		this.ticket_closed_by = ticket_closed_by;
	}

	public String getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(String active_flag) {
		this.active_flag = active_flag;
	}

	public CustomerMaster getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(CustomerMaster customer_id) {
		this.customer_id = customer_id;
	}
	
	public List<OrderProductMapping> getProducts() {
		return products;
	}
	
	public void setProducts(List<OrderProductMapping> products) {
		this.products = products;
	}

}
