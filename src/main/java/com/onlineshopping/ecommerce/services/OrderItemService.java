package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.model.Order;
import com.onlineshopping.ecommerce.model.OrderItem;
import com.onlineshopping.ecommerce.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface OrderItemService {

    OrderItem createOrderItem(Order order, Product product, Integer quantity, BigDecimal price);

    List<OrderItem> getOrderItemsByOrderId(Long orderId);

    void removeOrderItem(Long orderItemId);

    OrderItem getOrderItemById(Long orderItemId);

}
