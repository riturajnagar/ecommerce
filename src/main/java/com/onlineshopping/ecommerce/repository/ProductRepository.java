package com.onlineshopping.ecommerce.repository;

import com.onlineshopping.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Search by name or category
    Page<Product> findByNameContainingOrCategoryContaining(String name, String category, Pageable pageable);
}

