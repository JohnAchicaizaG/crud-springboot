package com.pruebas.crud.persistence;

import com.pruebas.crud.entities.ProductEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {
    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(Long id);

    void save(ProductEntity productEntity);

    void deleteById(Long id);

    List<ProductEntity> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
