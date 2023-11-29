package com.grocery.booking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.booking.app.model.GroceryItem;
import com.grocery.booking.app.model.Order;
import com.grocery.booking.app.services.GroceryItemService;
import com.grocery.booking.app.services.OrderService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private GroceryItemService groceryItemService;
	
	@Autowired
	private OrderService orderService;
	
	 @GetMapping("/grocery-items")
	    public ResponseEntity<List<GroceryItem>> getAvailableGroceryItems() {
	        List<GroceryItem> items = groceryItemService.getAllAvailableItems();
	        return ResponseEntity.ok(items);
	    }

	    @PostMapping("/orders")
	    public ResponseEntity<Order> createOrder(@RequestBody List<Long> itemIds) {
	        Order order = orderService.createOrder(itemIds);
	        return ResponseEntity.ok(order);
	    }

}
