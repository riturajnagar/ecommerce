package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(Long productId, Product product);

    public void deleteProduct(Long productId);

    Product getProductById(Long productId);

    Page<Product> searchProducts(String name, String category, int page, int size, String sortBy);

    List<Product> getAllProducts();
}

