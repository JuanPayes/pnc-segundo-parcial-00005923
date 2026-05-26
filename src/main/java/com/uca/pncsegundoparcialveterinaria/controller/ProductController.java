package com.uca.pncsegundoparcialveterinaria.controller;

import com.uca.pncsegundoparcialveterinaria.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;


}
