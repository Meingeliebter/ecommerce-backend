package com.beauty.ecommerce_backend.repository;

import com.beauty.ecommerce_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    // Spring genera el SQL automáticamente por el nombre del método:
    List<Product> findByActiveTrue();
    List<Product> findByNameContainingIgnoreCase(String name);

}
