package com.pruebatec.demo.services;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatec.demo.repository.FutbolistaRepository;
import com.pruebatec.demo.models.FutbolistaDTO;
import com.pruebatec.demo.models.Futbolistas;

@Service
public class FutbolistasServices {
	
	@Autowired
	private FutbolistaRepository futbolistaRepository;
	
	
	public Page<Futbolistas> obtenerFutbolistas(Pageable pageable){
		return futbolistaRepository.findAll(pageable);
	}
	
	public FutbolistaDTO obtenerFutbolistaPorId(Long id) {
		Futbolistas futbolista = futbolistaRepository.findById(id).orElse(null);
        if (futbolista != null) {
            // Transforma el objeto Futbolistas a FutbolistaDTO
            return new FutbolistaDTO(futbolista);
        } else {
            return null;
        }
	}

}
