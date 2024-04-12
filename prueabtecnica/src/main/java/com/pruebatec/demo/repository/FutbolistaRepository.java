package com.pruebatec.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import com.pruebatec.demo.models.Futbolistas;

public interface FutbolistaRepository extends CrudRepository<Futbolistas, Long>{
	@Query("SELECT f FROM Futbolistas f JOIN FETCH f.posicion")
    Page<Futbolistas> findAll(Pageable pageable);
}
