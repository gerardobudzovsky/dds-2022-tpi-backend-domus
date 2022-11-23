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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frre.utn.domus.dto.ReclamoDto;
import com.frre.utn.domus.entity.Reclamo;
import com.frre.utn.domus.service.ReclamoService;
import com.frre.utn.domus.utils.EnumPrioridad;

@CrossOrigin(origins = "http://localhost:3010")
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
	public List<Reclamo> find(
			@RequestParam(name = "cliente_nombre", required = false) String cliente_nombre,
			@RequestParam(name = "cliente_apellido", required = false) String cliente_apellido) throws Exception {
		return reclamoService.find(cliente_nombre, cliente_apellido);
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
    
    @RequestMapping(value = "/{reclamoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.PUT, RequestMethod.PATCH})
    @ResponseStatus(HttpStatus.OK)
    public Reclamo updatePropiedad(@RequestBody ReclamoDto reclamoDto, @PathVariable("reclamoId") Long reclamoId) throws Exception {
        return reclamoService.updateReclamo(reclamoId, reclamoDto);
    }
    
    @DeleteMapping(value = "/{reclamoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("reclamoId") Long reclamoId) throws Exception {
        reclamoService.deleteById(reclamoId);
    }
    
    @GetMapping(value = "/prioridad/{prioridad}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Reclamo> findByPrioridad(@PathVariable("prioridad") EnumPrioridad prioridad) throws Exception{
    	return reclamoService.findByPrioridad(prioridad);
    }
}
