package com.project.demo.logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.demo.logic.entity.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(String name);
}
