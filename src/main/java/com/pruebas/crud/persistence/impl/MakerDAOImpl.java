package com.pruebas.crud.persistence.impl;

import com.pruebas.crud.entities.MakerEntity;
import com.pruebas.crud.persistence.IMakerDAO;
import com.pruebas.crud.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {

    @Autowired
    private MakerRepository makerRepository;

    @Override
    public List<MakerEntity> findAll() {
        return (List<MakerEntity>) makerRepository.findAll();
    }

    @Override
    public Optional<MakerEntity> findById(Long id) {
        return makerRepository.findById(id);
    }

    @Override
    public void save(MakerEntity makerEntity) {
        makerRepository.save(makerEntity);
    }

    @Override
    public void deleteById(Long id) {
        makerRepository.deleteById(id);
    }
}
