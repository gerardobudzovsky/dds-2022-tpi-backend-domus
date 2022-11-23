package com.frre.utn.domus.controller;

import com.frre.utn.domus.dto.PropiedadDto;
import com.frre.utn.domus.entity.Propiedad;
import com.frre.utn.domus.service.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3010")
@RestController
@RequestMapping("/propiedades")
public class PropiedadController {

    private PropiedadService propiedadService;

    @Autowired
    public PropiedadController(PropiedadService propiedadService) {
        this.propiedadService = propiedadService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Propiedad> find(
    		@RequestParam(name = "cliente_id", required = false) Long clienteId
    		) throws Exception {
        return propiedadService.find(clienteId);
    }
    
    @GetMapping(value = "/{idPropiedad}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Propiedad getPropiedadById(@PathVariable("idPropiedad") Long idPropiedad) throws Exception {
        return propiedadService.getPropiedadById(idPropiedad);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Propiedad createPropiedad(@RequestBody PropiedadDto dto) throws Exception {
        return propiedadService.createPropiedad(dto);
    }

    @RequestMapping(value = "/{idPropiedad}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.PUT, RequestMethod.PATCH})
    @ResponseStatus(HttpStatus.OK)
    public Propiedad updatePropiedad(@RequestBody PropiedadDto dto, @PathVariable("idPropiedad") Long idPropiedad) throws Exception {
        return propiedadService.updatePropiedad(idPropiedad, dto);
    }

    @DeleteMapping(value = "/{idPropiedad}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePropiedadById(@PathVariable("idPropiedad") Long idPropiedad) throws Exception {
        propiedadService.deletePropiedadById(idPropiedad);
    }
}
