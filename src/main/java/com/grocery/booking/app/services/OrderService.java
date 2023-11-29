package com.grocery.booking.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.booking.app.model.GroceryItem;
import com.grocery.booking.app.model.Order;
import com.grocery.booking.app.repository.GroceryItemRepository;
import com.grocery.booking.app.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private GroceryItemRepository groceryItemRepository;
	
	public Order createOrder(List<Long> itemIds) {
		
        List<GroceryItem> items = groceryItemRepository.findAllById(itemIds);
      
        Order order = new Order();
        order.setItems(items);
      
        return orderRepository.save(order);
    }
}
