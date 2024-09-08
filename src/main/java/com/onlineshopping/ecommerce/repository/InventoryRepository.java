package com.onlineshopping.ecommerce.repository;

import com.onlineshopping.ecommerce.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByProductId(Long productId);
}

//@Lock(LockModeType.PESSIMISTIC_WRITE)
//@Query("SELECT i FROM Inventory i WHERE i.product.id = :productId")
//Inventory findAndLockByProductId(@Param("productId") Long productId);
