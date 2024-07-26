package com.pruebas.crud.service;

import com.pruebas.crud.entities.MakerEntity;

import java.util.List;
import java.util.Optional;

public interface IMakerService {
    List<MakerEntity> findAll();

    Optional<MakerEntity> findById(Long id);

    void save(MakerEntity makerEntity);

    void deleteById(Long id);
}
