package com.uca.pncsegundoparcialveterinaria.domain.dto.response.product;

import com.uca.pncsegundoparcialveterinaria.utils.enums.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record ProductResponse(
        String name,
        String description,
        BigDecimal price,
        Integer stock,
        Category category,
        Boolean available,
        Date expirationDate,
        Boolean requiredPrescription,
        String supplier) {

}
