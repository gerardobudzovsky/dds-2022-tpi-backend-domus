package com.frre.utn.domus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frre.utn.domus.dto.ClienteDto;
import com.frre.utn.domus.entity.Cliente;
import com.frre.utn.domus.mapper.ClienteMapper;
import com.frre.utn.domus.repository.ClienteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	private ClienteMapper clienteMapper;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
		this.clienteRepository = clienteRepository;
		this.clienteMapper = clienteMapper;
	}
	
    public Optional<Cliente> findById(Long clienteId) throws Exception{
        return clienteRepository.findById(clienteId);
    }

    public List<Cliente> find(String nombre, String apellido) throws Exception {
    	
    	if (nombre != null || apellido != null)
    		return clienteRepository.findByKeywords(nombre, apellido);
    	
        return clienteRepository.findAll();
    }
	
    public Cliente create(ClienteDto clienteDto) throws Exception {

        Cliente clienteEntity = clienteMapper.fromDto(clienteDto);

        return clienteRepository.save(clienteEntity);
    }
    
    public Cliente updateCliente(Long clienteId, ClienteDto clienteDto) throws Exception {
        Cliente clienteEntity = clienteRepository.findById(clienteId).orElseThrow(() -> new Exception("Error"));

        clienteEntity = clienteMapper.merger(clienteDto, clienteEntity);

        return clienteRepository.save(clienteEntity);
    }
    
    public void deleteById(Long clienteId) throws Exception {
        clienteRepository.deleteById(clienteId);
    }

}
