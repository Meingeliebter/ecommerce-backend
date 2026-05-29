package com.beauty.ecommerce_backend.service;

import com.beauty.ecommerce_backend.model.Product;
import com.beauty.ecommerce_backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findByActiveTrue();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));
    }

    public Product createProduct (Product product){
        return productRepository.save(product);
    }

    public Product updateProduct (Long id, Product productDetails){
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        product.setImageUrl(productDetails.getImageUrl());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        Product product = getProductById(id);
        product.setActive(false); //Borrado Logico
        productRepository.save(product);
    }

}


