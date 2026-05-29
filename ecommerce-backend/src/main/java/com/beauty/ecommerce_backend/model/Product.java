package com.beauty.ecommerce_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table (name = "products")
@Data

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "El nombre es requerido")
    @Column(nullable = false)
    private String name;

    private String description;

    @NotNull(message = "El precio es requerido")
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Min(0)
    @Column(nullable = false)
    private Integer stock = 0;

    private String imageUrl;

    @Column(nullable = false)
    private Boolean active = true;

}
