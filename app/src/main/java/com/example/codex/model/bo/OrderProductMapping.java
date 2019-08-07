package com.example.codex.model.bo;

import java.io.Serializable;


public class OrderProductMapping implements Serializable {
	private Long idOrderproduct;
	private Long order_id;
	private ProductMaster product_id;
	private Integer quantity;

	public Long getIdOrderproduct() {
		return idOrderproduct;
	}

	public void setIdOrderproduct(Long idOrderproduct) {
		this.idOrderproduct = idOrderproduct;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public ProductMaster getProduct_id() {
		return product_id;
	}

	public void setProduct_id(ProductMaster product_id) {
		this.product_id = product_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
