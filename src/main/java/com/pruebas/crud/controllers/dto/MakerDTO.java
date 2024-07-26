package com.pruebas.crud.controllers.dto;

import com.pruebas.crud.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {
    private Long id;

    private String name;

    private List<ProductEntity> productList = new ArrayList<>();
}
