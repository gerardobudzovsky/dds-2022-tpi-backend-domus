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

import com.frre.utn.domus.dto.ClienteDto;
import com.frre.utn.domus.entity.Cliente;
import com.frre.utn.domus.service.ClienteService;

@CrossOrigin(origins = "http://localhost:3010")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> find(
			@RequestParam(name = "nombre", required = false) String nombre,
			@RequestParam(name = "apellido", required = false) String apellido) throws Exception {
		return clienteService.find(nombre, apellido);
	}
    
    @GetMapping(value = "/{clienteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cliente> findById(@PathVariable(name = "clienteId") Long clienteId) throws Exception{
    	return clienteService.findById(clienteId);
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody ClienteDto clienteDto) throws Exception {
        return clienteService.create(clienteDto);
    }
    
    @RequestMapping(value = "/{clienteId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.PUT, RequestMethod.PATCH})
    @ResponseStatus(HttpStatus.OK)
    public Cliente updateCliente(@RequestBody ClienteDto clienteDto, @PathVariable("clienteId") Long clienteId) throws Exception {
        return clienteService.updateCliente(clienteId, clienteDto);
    }
    
    @DeleteMapping(value = "/{clienteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("clienteId") Long clienteId) throws Exception {
        clienteService.deleteById(clienteId);
    }
    
    @PostMapping(value = "/{cliente_id}/vincular_propiedad/{propiedad_id}")
	@ResponseStatus(HttpStatus.OK)
	public void vincularPropiedadACliente(
			@PathVariable("cliente_id") Long clienteId,
			@PathVariable("propiedad_id") Long propiedadId) throws Exception {
		clienteService.vincularPropiedad(clienteId, propiedadId);
	}
}
