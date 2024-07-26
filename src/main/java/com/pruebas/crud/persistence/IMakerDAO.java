package com.pruebas.crud.persistence;

import com.pruebas.crud.entities.MakerEntity;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {
    List<MakerEntity> findAll();

    Optional<MakerEntity> findById(Long id);

    void save(MakerEntity makerEntity);

    void deleteById(Long id);
}
