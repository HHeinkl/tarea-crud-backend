package com.project.demo.rest.product;

import com.project.demo.logic.dto.ProductDTO;
import com.project.demo.logic.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN_ROLE')")
    public ProductDTO create(@RequestBody ProductDTO dto) {
        return productService.createProduct(dto);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<ProductDTO> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ProductDTO getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN_ROLE')")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO dto) {
        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN_ROLE')")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}