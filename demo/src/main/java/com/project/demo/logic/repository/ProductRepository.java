package com.project.demo.logic.repository;

import com.project.demo.logic.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);  // Búsqueda por categoría
}