package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.exceptions.EntityNotFoundException;
import com.onlineshopping.ecommerce.model.Inventory;
import com.onlineshopping.ecommerce.repository.InventoryRepository;
import com.onlineshopping.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory updateInventory(Long productId, Integer quantity) {
        Inventory inventory = getInventoryByProductId(productId);
        inventory.setQuantity(quantity);
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getInventoryByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new EntityNotFoundException("Inventory not found for product id: " + productId));
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

}
