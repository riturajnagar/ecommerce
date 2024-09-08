package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.exceptions.EntityNotFoundException;
import com.onlineshopping.ecommerce.model.Product;
import com.onlineshopping.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product productDetails) {
        Product product = getProductById(productId);
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = getProductById(productId);
        productRepository.delete(product);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
    }

    @Override
    public Page<Product> searchProducts(String name, String category, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return productRepository.findByNameContainingOrCategoryContaining(name, category, pageable);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
