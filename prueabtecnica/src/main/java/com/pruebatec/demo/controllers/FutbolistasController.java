package com.pruebatec.demo.controllers;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatec.demo.models.FutbolistaDTO;
import com.pruebatec.demo.models.Futbolistas;
import com.pruebatec.demo.services.FutbolistasServices;

@RestController
@RequestMapping("/futbolistas")
public class FutbolistasController {
	
	@Autowired
	private FutbolistasServices futbolistasServices;
	
	@GetMapping("/all")
    public ResponseEntity<Page<FutbolistaDTO>> obtenerTodosLosFutbolistas(Pageable pageable) {
        Page<Futbolistas> futbolistas = futbolistasServices.obtenerFutbolistas(pageable);
        Page<FutbolistaDTO> futbolistasDTO = futbolistas.map(FutbolistaDTO::new);
        return ResponseEntity.ok(futbolistasDTO);
    }
	
	
	@GetMapping("/{id}")
	public ResponseEntity<FutbolistaDTO> obtenerFutbolistaId(@PathVariable Long id){
		FutbolistaDTO futbolista = futbolistasServices.obtenerFutbolistaPorId(id);
		if(futbolista != null) {
			return ResponseEntity.ok(futbolista);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	
	
//	@GetMapping("/all")
//    public ResponseEntity<List<FutbolistaDTO>> obtenerTodosLosFutbolistas() {`
//        List<Futbolistas> futbolistas = futbolistasServices.obtenerFutbolistas();
//        // Transforma la lista de Futbolistas a una lista de FutbolistaDTO usando streams
//        List<FutbolistaDTO> futbolistasDTO = futbolistas.stream()
//                .map(FutbolistaDTO::new)
//                .collect(Collectors.toList());
//        // Retorna la lista de DTOs
//        return ResponseEntity.ok(futbolistasDTO);
//    }

}
