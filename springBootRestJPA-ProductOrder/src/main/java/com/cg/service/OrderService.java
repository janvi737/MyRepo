package com.cg.service;

import com.cg.dto.OrderDTO;
import com.cg.entity.Order;
import com.cg.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
 
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
 
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderDTO(order.getOrderId(), order.getOrderDate()))
                .collect(Collectors.toList());
    }
 
    public OrderDTO getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(o -> new OrderDTO(o.getOrderId(), o.getOrderDate())).orElse(null);
    }
 
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderDate(orderDTO.getOrderDate());
        Order savedOrder = orderRepository.save(order);
        return new OrderDTO(savedOrder.getOrderId(), savedOrder.getOrderDate());
    }
 
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setOrderDate(orderDTO.getOrderDate());
            Order updatedOrder = orderRepository.save(order);
            return new OrderDTO(updatedOrder.getOrderId(), updatedOrder.getOrderDate());
        }
        return null;
    }
 
    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}