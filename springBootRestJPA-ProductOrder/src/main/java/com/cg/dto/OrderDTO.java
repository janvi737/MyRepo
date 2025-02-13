package com.cg.dto;

import java.time.LocalDate;

public class OrderDTO {
	private Long orderId;
	private LocalDate orderDate;
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(Long orderId, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
}
