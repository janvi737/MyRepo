package com.cg.service;

import java.util.List;

import com.cg.dto.OrderDTO;

public interface IOrderService {
	
	public List<OrderDTO> getAllOrders();
	
	public OrderDTO getOrderById(Long id);
	
	public OrderDTO createOrder(OrderDTO orderDTO) ;
	
	public OrderDTO updateOrder(Long id, OrderDTO orderDTO) ;
	
	public boolean deleteOrder(Long id);
	

}
