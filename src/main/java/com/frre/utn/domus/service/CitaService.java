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

	public List<Cita> getAllCita(String keyword) throws Exception {
		
		if (keyword != null) {
			return citaRepository.findByKeyword(keyword);
		}
		return citaRepository.findAll();
	}
	
	public List<Cita> findByPropiedad_Id(Long propiedadId) {
		return citaRepository.findByPropiedad_Id(propiedadId);
	}
	
	public List<Cita> find(String propiedad_calle, Integer propiedad_numero) {
		
		if (propiedad_calle != null && propiedad_numero != null) {
			return citaRepository.findByPropiedad_CalleAndPropiedad_Numero(propiedad_calle, propiedad_numero);
		}
		
		if (propiedad_calle != null) {
			return citaRepository.findByPropiedad_Calle(propiedad_calle);
		}
		
		if (propiedad_numero != null) {
			return citaRepository.findByPropiedad_Numero(propiedad_numero);
		}
		
		return citaRepository.findAll();
	}

}
