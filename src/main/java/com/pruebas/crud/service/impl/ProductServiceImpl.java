package com.pruebas.crud.service.impl;

import com.pruebas.crud.entities.ProductEntity;
import com.pruebas.crud.persistence.IProductDAO;
import com.pruebas.crud.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Override
    public List<ProductEntity> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    public void save(ProductEntity productEntity) {
        productDAO.save(productEntity);
    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    public List<ProductEntity> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productDAO.findByPriceInRange(minPrice, maxPrice);
    }
}
