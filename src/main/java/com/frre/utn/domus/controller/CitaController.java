package com.frre.utn.domus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frre.utn.domus.entity.Cita;
import com.frre.utn.domus.service.CitaService;

@RestController
@RequestMapping("/cita")
public class CitaController {
	
	private CitaService citaService;
	
	@Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }
	
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Cita> find(
    						@RequestParam(name = "keyword", required = false) String keyword,
    						@RequestParam(name = "nombreSolicitante", required = false) String nombreSolicitante,
    						@RequestParam(name = "observaciones", required = false) String observaciones
    					  ) throws Exception {
        return citaService.find(keyword, nombreSolicitante, observaciones);
    }
    
    @GetMapping(value = "/{citaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cita> findById(@PathVariable(name = "citaId") Long citaId) throws Exception{
    	return citaService.findById(citaId);
    }
    
    @GetMapping(value = "/propiedad", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Cita> findByPropiedad(
    								  @RequestParam(name = "calle", required = false) String calle,
    								  @RequestParam(name= "numero", required = false) Integer numero
    								 ) throws Exception{
    	return citaService.findByPropiedad(calle, numero);
    }
        
    @GetMapping(value = "/propiedad/{propiedadId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Cita> findByPropiedad_Id(@PathVariable("propiedadId") Long propiedadId) throws Exception{
    	return citaService.findByPropiedad_Id(propiedadId);
    }
    

	
}
