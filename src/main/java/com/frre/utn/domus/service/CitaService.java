package com.frre.utn.domus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frre.utn.domus.entity.Cita;
import com.frre.utn.domus.repository.CitaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CitaService {

	private CitaRepository citaRepository;

	@Autowired
	public CitaService(CitaRepository citaRepository) {
		this.citaRepository = citaRepository;
	}

	public List<Cita> getAllCita() throws Exception {
		return citaRepository.findAll();
	}

}
