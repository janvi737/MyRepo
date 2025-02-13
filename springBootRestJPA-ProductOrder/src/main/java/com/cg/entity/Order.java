package com.cg.entity;


import jakarta.persistence.*;
import java.time.LocalDate;
 
@Entity
@Table(name = "productorder")


public class Order {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long orderId;
	 
	    @Column(name="OrderDate",nullable = false)
	    private LocalDate orderDate;

		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Order(Long orderId, LocalDate orderDate) {
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


