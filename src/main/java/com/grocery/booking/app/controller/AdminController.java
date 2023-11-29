package com.grocery.booking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.booking.app.model.GroceryItem;
import com.grocery.booking.app.services.GroceryItemService;

@RestController
@RequestMapping("/api/admin/grocery-items")
public class AdminController {

	@Autowired
	private GroceryItemService groceryItemService;
	
	 @PostMapping
	    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem item) {
	        GroceryItem newItem = groceryItemService.addGroceryItem(item);
	        return ResponseEntity.ok(newItem);
	    }

	    @GetMapping
	    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
	        List<GroceryItem> items = groceryItemService.getAllGroceryItems();
	        return ResponseEntity.ok(items);
	    }

	    @DeleteMapping("/{itemId}")
	    public ResponseEntity<Void> removeGroceryItem(@PathVariable Long itemId) {
	        groceryItemService.removeGroceryItem(itemId);
	        return ResponseEntity.noContent().build();
	    }

	    @PutMapping("/{itemId}")
	    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long itemId, @RequestBody GroceryItem updatedItem) {
	        GroceryItem item = groceryItemService.updateGroceryItem(itemId, updatedItem);
	        return ResponseEntity.ok(item);
	    }

	    @PatchMapping("/{itemId}")
	    public ResponseEntity<GroceryItem> manageInventory(
	            @PathVariable Long itemId,
	            @RequestParam(name = "quantityChange") int quantityChange) {
	        GroceryItem item = groceryItemService.manageInventory(itemId, quantityChange);
	        return ResponseEntity.ok(item);
	    }
}
