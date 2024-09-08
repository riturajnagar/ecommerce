package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.model.Order;
import com.onlineshopping.ecommerce.model.OrderItem;

import java.util.List;

public interface OrderService {

    Order placeOrder(Long userId);

    List<Order> getOrdersByUserId(Long userId);

    Order getOrderById(Long orderId);

    List<OrderItem> getOrderItems(Long orderId);
}

