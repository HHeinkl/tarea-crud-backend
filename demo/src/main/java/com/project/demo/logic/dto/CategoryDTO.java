package com.project.demo.logic.dto;

import java.time.LocalDateTime;

public class CategoryDTO {
    private Long id;
    private String name;
    private LocalDateTime createdAt;

    public CategoryDTO() {}

    // ----- Getters y Setters -----
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}