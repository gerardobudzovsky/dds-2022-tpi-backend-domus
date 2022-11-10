package com.frre.utn.domus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frre.utn.domus.dto.ClienteDto;
import com.frre.utn.domus.dto.SecretariaDto;
import com.frre.utn.domus.entity.Cliente;
import com.frre.utn.domus.entity.Secretaria;
import com.frre.utn.domus.mapper.SecretariaMapper;
import com.frre.utn.domus.repository.SecretariaRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SecretariaService {
	
	private SecretariaRepository secretariaRepository;
	private SecretariaMapper secretariaMapper;
	
	@Autowired
	public SecretariaService(SecretariaRepository clienteRepository, SecretariaMapper clienteMapper) {
		this.secretariaRepository = clienteRepository;
		this.secretariaMapper = clienteMapper;
	}
	
    public Optional<Secretaria> findById(Long secretariaId) throws Exception{
        return secretariaRepository.findById(secretariaId);
    }

    public List<Secretaria> findAll() throws Exception {
        return secretariaRepository.findAll();
    }
	
    public Secretaria create(SecretariaDto secretariaDto) throws Exception {

        Secretaria secretariaEntity = secretariaMapper.fromDto(secretariaDto);

        return secretariaRepository.save(secretariaEntity);
    }
    
    public Secretaria updateSecretaria(Long secretariaId, SecretariaDto secretariaDto) throws Exception {
        Secretaria secretariaEntity = secretariaRepository.findById(secretariaId).orElseThrow(() -> new Exception("Error"));

        secretariaEntity = secretariaMapper.merger(secretariaDto, secretariaEntity);

        return secretariaRepository.save(secretariaEntity);
    }
    
    public void deleteById(Long secretariaId) throws Exception {
        secretariaRepository.deleteById(secretariaId);
    }

}
