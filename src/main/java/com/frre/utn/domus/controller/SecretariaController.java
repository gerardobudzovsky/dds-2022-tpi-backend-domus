package com.frre.utn.domus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frre.utn.domus.dto.SecretariaDto;
import com.frre.utn.domus.entity.Secretaria;
import com.frre.utn.domus.service.SecretariaService;

@CrossOrigin(origins = "http://localhost:3010")
@RestController
@RequestMapping("/secretarias")
public class SecretariaController {

	private SecretariaService secretariaService;
	
	@Autowired
	public SecretariaController(SecretariaService secretariaService) {
		this.secretariaService = secretariaService;
	}
	
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Secretaria> findAll() throws Exception {
        return secretariaService.findAll();
    }
    
    @GetMapping(value = "/{secretariaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Secretaria> findById(@PathVariable(name = "secretariaId") Long secretariaId) throws Exception{
    	return secretariaService.findById(secretariaId);
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Secretaria create(@RequestBody SecretariaDto secretariaDto) throws Exception {
        return secretariaService.create(secretariaDto);
    }
    
    @RequestMapping(value = "/{secretariaId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.PUT, RequestMethod.PATCH})
    @ResponseStatus(HttpStatus.OK)
    public Secretaria updateCliente(@RequestBody SecretariaDto secretariaDto, @PathVariable("secretariaId") Long secretariaId) throws Exception {
        return secretariaService.updateSecretaria(secretariaId, secretariaDto);
    }
    
    @DeleteMapping(value = "/{secretariaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("secretariaId") Long secretariaId) throws Exception {
        secretariaService.deleteById(secretariaId);
    }
}
