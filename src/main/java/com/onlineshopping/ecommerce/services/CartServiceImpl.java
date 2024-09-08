package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.model.Cart;
import com.onlineshopping.ecommerce.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{


    @Override
    public Cart getCartByUserId(Long userId) {
        return null;
    }

    @Override
    public Cart addItemToCart(Long userId, Long productId, Integer quantity) {
        return null;
    }

    @Override
    public Cart removeItemFromCart(Long userId, Long productId) {
        return null;
    }

    @Override
    public Cart updateCartItem(Long userId, Long productId, Integer quantity) {
        return null;
    }

    @Override
    public Cart clearCart(Long userId) {
        return null;
    }

    @Override
    public Cart getCartById(Long cartId) {
        return null;
    }

    @Override
    public List<CartItem> getCartItems(Long cartId) {
        return List.of();
    }
}
