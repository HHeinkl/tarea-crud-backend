package com.project.demo.logic.entity.category;

import com.project.demo.logic.entity.product.Product;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categories") // Nombre de tabla en plural
public class Category { // Clase como entidad JPA

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    // Auditoría (igual que en User)
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    // Relación 1:N con Product (mapeada por el campo "category" en Product)
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;

    // Constructor vacío (requerido por JPA)
    public Category() {}

    // ---- Getters y Setters (igual que en User) ----
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    // ... (implementa todos los getters/setters)
}
