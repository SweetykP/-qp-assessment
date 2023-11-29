package com.grocery.booking.app.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.booking.app.model.GroceryItem;
import com.grocery.booking.app.repository.GroceryItemRepository;

@Service
public class GroceryItemService {
	
	@Autowired
	private GroceryItemRepository groceryItemRepository;
	
	 public List<GroceryItem> getAllAvailableItems() {
	         return groceryItemRepository.findAll();
	    }
	 
	 public GroceryItem addGroceryItem(GroceryItem item) {
	        return groceryItemRepository.save(item);
	    }


	    public List<GroceryItem> getAllGroceryItems() {
	        return groceryItemRepository.findAll();
	    }

	    public void removeGroceryItem(Long itemId) {
	        groceryItemRepository.deleteById(itemId);
	    }

	    // Method to update details of a grocery item
	    public GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem) {
	        // Check if the item exists in the database
	        GroceryItem existingItem = groceryItemRepository.findById(itemId)
	                .orElseThrow(() -> new NoSuchElementException("Grocery item not found"));

	        // Update the details
	        existingItem.setName(updatedItem.getName());
	        existingItem.setPrice(updatedItem.getPrice());
	        existingItem.setQuantity(updatedItem.getQuantity());

	        return groceryItemRepository.save(existingItem);
	    }

	    // Method to manage inventory levels of a grocery item
	    public GroceryItem manageInventory(Long itemId, int quantityChange) {
	         GroceryItem item = groceryItemRepository.findById(itemId)
	                .orElseThrow(() -> new NoSuchElementException("Grocery item not found"));

	        // Update the inventory level
	        int updatedQuantity = item.getQuantity() + quantityChange;
	        item.setQuantity(updatedQuantity < 0 ? 0 : updatedQuantity);

	        return groceryItemRepository.save(item);
	    }

	

}
