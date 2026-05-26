package com.uca.pncsegundoparcialveterinaria.utils.mappers;

import com.uca.pncsegundoparcialveterinaria.domain.dto.response.product.ProductResponse;
import com.uca.pncsegundoparcialveterinaria.domain.dto.rquest.CreateProductRequest;
import com.uca.pncsegundoparcialveterinaria.domain.dto.rquest.UpdateProductRequest;
import com.uca.pncsegundoparcialveterinaria.domain.entities.Product;

import java.util.List;

public class ProductMapper {

    public static Product toEntity(CreateProductRequest request){
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .stock(request.stock())
                .available(request.available())
                .category(request.category())
                .expirationDate(request.expirationDate())
                .requiredPrescription(request.requiredPrescription())
                .supplier(request.supplier())
                .build();
    }

    public static ProductResponse toResponse(Product product){
        return new ProductResponse(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory(),
                product.getAvailable(),
                product.getExpirationDate(),
                product.getRequiredPrescription(),
                product.getSupplier()
        );
    }

    public static CreateProductRequest toDTO(Product product){
        return CreateProductRequest.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .available(product.getAvailable())
                .category(product.getCategory())
                .expirationDate(product.getExpirationDate())
                .requiredPrescription(product.getRequiredPrescription())
                .supplier(product.getSupplier())
                .build();
    }

    public static Product toUpdateEntity(UpdateProductRequest request){

        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .stock(request.stock())
                .available(request.available())
                .category(request.category())
                .expirationDate(request.expirationDate())
                .requiredPrescription(request.requiredPrescription())
                .supplier(request.supplier())
                .build();
    }

    public static UpdateProductRequest toUpdateDTO(Product product){
        return UpdateProductRequest.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .available(product.getAvailable())
                .category(product.getCategory())
                .expirationDate(product.getExpirationDate())
                .requiredPrescription(product.getRequiredPrescription())
                .supplier(product.getSupplier())
                .build();
    }
}
