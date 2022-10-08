package com.frre.utn.domus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frre.utn.domus.dto.PropiedadDto;
import com.frre.utn.domus.dto.ReclamoDto;
import com.frre.utn.domus.entity.Propiedad;
import com.frre.utn.domus.entity.Reclamo;
import com.frre.utn.domus.service.ReclamoService;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {

	private ReclamoService reclamoService;
	
	@Autowired
	public ReclamoController(ReclamoService reclamoService) {
		this.reclamoService = reclamoService;
	}
	
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Reclamo> findAll() throws Exception {
        return reclamoService.findAll();
    }
    
    @GetMapping(value = "/{reclamoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Reclamo> findById(@PathVariable(name = "reclamoId") Long reclamoId) throws Exception{
    	return reclamoService.findById(reclamoId);
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Reclamo create(@RequestBody ReclamoDto reclamoDto) throws Exception {
        return reclamoService.create(reclamoDto);
    }
}
