package com.pruebas.crud.repository;

import com.pruebas.crud.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.price BETWEEN ?1 AND ?2")
    List<ProductEntity> findProductByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    List<ProductEntity> findProductEntityByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
