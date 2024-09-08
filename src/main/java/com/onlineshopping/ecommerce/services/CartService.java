package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.model.Cart;
import com.onlineshopping.ecommerce.model.CartItem;

import java.util.List;

public interface CartService {

    Cart getCartByUserId(Long userId);

    Cart addItemToCart(Long userId, Long productId, Integer quantity);

    Cart removeItemFromCart(Long userId, Long productId);

    Cart updateCartItem(Long userId, Long productId, Integer quantity);

    Cart clearCart(Long userId);

    Cart getCartById(Long cartId);

    List<CartItem> getCartItems(Long cartId);
}
