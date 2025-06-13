package com.project.demo.logic.entity.product;

import com.project.demo.logic.entity.category.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

@Entity
@Table(name = "products") // Tabla en plural
public class Product { // Clase como entidad JPA

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    // Auditoría (igual que en User y Category)
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    // Relación N:1 con Category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Constructor vacío
    public Product() {}

    // ---- Getters y Setters ----
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    // ... (implementa todos los getters/setters)
}
