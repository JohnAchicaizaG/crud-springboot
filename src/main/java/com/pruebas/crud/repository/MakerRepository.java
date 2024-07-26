package com.pruebas.crud.repository;

import com.pruebas.crud.entities.MakerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository<MakerEntity, Long> {
}
