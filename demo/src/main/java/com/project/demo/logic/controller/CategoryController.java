package com.project.demo.logic.controller;

import com.project.demo.logic.dto.CategoryDTO;
import com.project.demo.logic.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController // Clase Java para endpoints REST
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
        return service.createCategory(dto);
    }
}