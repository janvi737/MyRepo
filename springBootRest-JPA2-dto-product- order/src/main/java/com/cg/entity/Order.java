package com.cg.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="OrderTable")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int orderId;
	@Column(name="orderDate")
private Date orderDate;
	
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	orderDate = orderDate;
}
public Order(int orderId, Date orderDate) {
	super();
	this.orderId = orderId;
	orderDate = orderDate;
}
public Order() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Order [orderId=" + orderId + ", OrderDate=" + orderDate + "]";
}


}
