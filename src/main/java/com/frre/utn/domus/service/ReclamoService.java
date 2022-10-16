package com.frre.utn.domus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frre.utn.domus.dto.ReclamoDto;
import com.frre.utn.domus.entity.Reclamo;
import com.frre.utn.domus.mapper.ReclamoMapper;
import com.frre.utn.domus.repository.ReclamoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReclamoService {

	private ReclamoRepository reclamoRepository;
	private ReclamoMapper reclamoMapper;

	@Autowired
	public ReclamoService(ReclamoRepository reclamoRepository, ReclamoMapper reclamoMapper) {
		this.reclamoRepository = reclamoRepository;
		this.reclamoMapper = reclamoMapper;
	}
	
    public Optional<Reclamo> findById(Long idReclamo) throws Exception{
        return reclamoRepository.findById(idReclamo);
    }

    public List<Reclamo> findAll() throws Exception {
        return reclamoRepository.findAll();
    }
	
    public Reclamo create(ReclamoDto reclamoDto) throws Exception {

        Reclamo reclamoEntity = reclamoMapper.fromDto(reclamoDto);

        return reclamoRepository.save(reclamoEntity);
    }
	
}
