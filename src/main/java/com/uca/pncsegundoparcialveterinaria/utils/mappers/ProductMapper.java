package com.uca.pncsegundoparcialveterinaria.utils.mappers;

import com.uca.pncsegundoparcialveterinaria.domain.dto.rquest.CreateProductRequest;
import com.uca.pncsegundoparcialveterinaria.domain.dto.rquest.UpdateProductRequest;
import com.uca.pncsegundoparcialveterinaria.domain.entities.Product;

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

    public static UpdateProductRequest toUpdateEntity(UpdateProductRequest request){

        return UpdateProductRequest.builder()
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
