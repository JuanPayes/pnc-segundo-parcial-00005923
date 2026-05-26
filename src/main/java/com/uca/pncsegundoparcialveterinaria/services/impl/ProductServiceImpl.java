package com.uca.pncsegundoparcialveterinaria.services.impl;

import com.uca.pncsegundoparcialveterinaria.domain.dto.response.product.ProductResponse;
import com.uca.pncsegundoparcialveterinaria.domain.dto.rquest.CreateProductRequest;
import com.uca.pncsegundoparcialveterinaria.domain.dto.rquest.UpdateProductRequest;
import com.uca.pncsegundoparcialveterinaria.domain.entities.Product;
import com.uca.pncsegundoparcialveterinaria.repository.ProductRepository;
import com.uca.pncsegundoparcialveterinaria.services.ProductService;
import com.uca.pncsegundoparcialveterinaria.utils.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public CreateProductRequest createProduct(CreateProductRequest request) {

        if (productRepository.existsByName(request.name())){
            throw new IllegalArgumentException("Product with name " + request.name() + " already exists");
        }

        return ProductMapper.toDTO(
                productRepository.save(
                        ProductMapper.toEntity(request)
                )
        );
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductResponse getProductById(long id) {
        return ProductMapper.toResponse(
                productRepository.findById(id).orElseThrow(
                        () -> new IllegalArgumentException("Product not found with id " + id)
                )
        );
    }

    @Override
    public void updateProductById(long id, UpdateProductRequest request) {
        Product updateEntity = ProductMapper.toUpdateEntity(request);
        if (productRepository.existsById(id)){
            updateEntity.setId(id);
        }else{
            throw new IllegalArgumentException("Product not found with id " + id);
        }
        productRepository.save(updateEntity);
    }

    @Override
    public void deleteProductById(long id) {
    productRepository.deleteById(id);
        return ;
    }
}
