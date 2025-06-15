package com.project.demo.logic.service;

import com.project.demo.logic.dto.CategoryDTO;
import com.project.demo.logic.entity.category.Category;
import com.project.demo.logic.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CategoryDTO createCategory(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        Category savedCategory = repository.save(category);
        return convertToDTO(savedCategory);
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> getAllCategories() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDTO getCategoryById(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Transactional
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        return repository.findById(id)
                .map(existingCategory -> {
                    existingCategory.setName(dto.getName());
                    existingCategory.setDescription(dto.getDescription());
                    Category updatedCategory = repository.save(existingCategory);
                    return convertToDTO(updatedCategory);
                })
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Transactional
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setCreatedAt(category.getCreatedAt());
        dto.setUpdatedAt(category.getUpdatedAt());
        return dto;
    }
}