package com.uca.pncsegundoparcialveterinaria.domain.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ApiErrorResponse {
    private String message;
    private int code;
    private LocalDate timestamp;
    private Object errors;
}
