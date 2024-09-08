package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.model.Inventory;

import java.util.List;

public interface InventoryService {

    Inventory addInventory(Inventory inventory);

    Inventory updateInventory(Long productId, Integer quantity);

    Inventory getInventoryByProductId(Long productId);

    List<Inventory> getAllInventory();
}

