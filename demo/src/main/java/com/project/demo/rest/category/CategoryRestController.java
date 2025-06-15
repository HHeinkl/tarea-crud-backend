package com.project.demo.rest.category;

import com.project.demo.logic.dto.CategoryDTO;
import com.project.demo.logic.service.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryService service;

    public CategoryRestController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
        return service.createCategory(dto);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<CategoryDTO> getAll() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public CategoryDTO getById(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public CategoryDTO update(@PathVariable Long id, @RequestBody CategoryDTO dto) {
        return service.updateCategory(id, dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public void delete(@PathVariable Long id) {
        service.deleteCategory(id);
    }
}