package com.project.demo.logic.service;

import com.project.demo.logic.dto.CategoryDTO;
import com.project.demo.logic.entity.category.Category;
import com.project.demo.logic.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service // Anotación de Spring para clases de servicio
public class CategoryService {
    private final CategoryRepository repository;

    // Inyección de dependencias (constructor)
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public CategoryDTO createCategory(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        repository.save(category);
        return convertToDTO(category);
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}