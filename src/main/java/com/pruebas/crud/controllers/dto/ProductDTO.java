package com.pruebas.crud.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pruebas.crud.entities.MakerEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    @NotBlank(message = "nombre obligatorio")
    private String name;
    @NotNull(message = "precio obligatorio")
    private BigDecimal price;
    @NotNull(message = "fabricante obligatorio")
    private MakerEntity maker;
}
