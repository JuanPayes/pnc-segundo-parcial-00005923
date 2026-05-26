package com.uca.pncsegundoparcialveterinaria.domain.dto.rquest;

import com.uca.pncsegundoparcialveterinaria.utils.enums.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

@Builder
public record CreateProductRequest(
        @NotNull(message = "El nombre no debe de ser nula")
        String name,
        String description,
        @Min(value = 1, message = "El precio no puede ser negativo")
        BigDecimal price,
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock,

        Category category,

        Boolean available,
        @NotNull(message = "La fecha no puede ser nula")
        Date expirationDate,

        Boolean requiredPrescription,
        @NotNull(message = "La categoría no debe de ser nula")
        String supplier
) {}
