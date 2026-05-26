package com.uca.pncsegundoparcialveterinaria.services;

import com.uca.pncsegundoparcialveterinaria.domain.dto.response.product.ProductResponse;
import com.uca.pncsegundoparcialveterinaria.domain.dto.rquest.CreateProductRequest;
import com.uca.pncsegundoparcialveterinaria.domain.dto.rquest.UpdateProductRequest;
import com.uca.pncsegundoparcialveterinaria.domain.entities.Product;

import java.util.List;

public interface ProductService {
    public CreateProductRequest createProduct(CreateProductRequest request);
    public List<Product> getAllProducts();
    public ProductResponse getProductById(long id);
    public void updateProductById(long id, UpdateProductRequest request);
    public void deleteProductById(long id);
}
