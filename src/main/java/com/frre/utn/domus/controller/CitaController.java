package com.frre.utn.domus.controller;

import java.util.List;

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
import com.frre.utn.domus.entity.Propiedad;
import com.frre.utn.domus.service.CitaService;
import com.frre.utn.domus.service.PropiedadService;

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
    public List<Cita> getAllCitas(@RequestParam(value = "keyword", required = false) String keyword) throws Exception {
        return citaService.getAllCita(keyword);
    }
    
    @GetMapping(value = "/propiedad/{propiedadId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Cita> findByPropiedad_Id(@PathVariable("propiedadId") Long propiedadId) throws Exception{
    	return citaService.findByPropiedad_Id(propiedadId);
    }
    
    @GetMapping(value = "/propiedad", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Cita> find(@RequestParam(name = "calle", required = false) String calle, @RequestParam(name= "numero", required = false) Integer numero) throws Exception{
    	return citaService.find(calle, numero);
    }
	
}
