package com.pruebas.crud.service.impl;

import com.pruebas.crud.entities.MakerEntity;
import com.pruebas.crud.persistence.IMakerDAO;
import com.pruebas.crud.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements IMakerService {

    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public List<MakerEntity> findAll() {
        return makerDAO.findAll();
    }

    @Override
    public Optional<MakerEntity> findById(Long id) {
        return makerDAO.findById(id);
    }

    @Override
    public void save(MakerEntity makerEntity) {
        makerDAO.save((makerEntity));
    }

    @Override
    public void deleteById(Long id) {
        makerDAO.deleteById(id);
    }
}
