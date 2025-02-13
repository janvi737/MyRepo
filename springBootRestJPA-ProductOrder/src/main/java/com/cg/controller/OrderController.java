package com.cg.controller;

import com.cg.dto.OrderDTO;
import com.cg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/oapi/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
 
    
    //http://locahost:9090/oapi/orders
    @GetMapping("/allorders")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }
 
    
    //http://locahost:9090/oapi/orders/1
    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
 
    
    //http://locahost:9090/oapi/orders
    @PostMapping("/postorder")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }
 
    //http://locahost:9090/oapi/orders/1
    @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(id, orderDTO);
    }
 
    
    //http://locahost:9090/oapi/orders/2
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id) ? "Order deleted" : "Order not found";
    }
}