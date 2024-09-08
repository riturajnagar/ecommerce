package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.model.CartItem;

import java.util.List;

public interface CartItemService {

    CartItem addCartItem(Long cartId, Long productId, Integer quantity);

    CartItem updateCartItem(Long cartItemId, Integer quantity);

    public void removeCartItem(Long cartItemId);

    CartItem getCartItemById(Long cartItemId);

    List<CartItem> getCartItemsByCartId(Long cartId);
}
