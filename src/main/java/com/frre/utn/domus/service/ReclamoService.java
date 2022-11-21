package com.frre.utn.domus.service;

import java.util.List;
import java.util.Optional;

import com.frre.utn.domus.utils.EnumEstadoReclamo;
import com.frre.utn.domus.utils.EnumPrioridad;

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

    public List<Reclamo> find(String cliente_nombre, String cliente_apellido) throws Exception {
    	
    	if (cliente_nombre != null  || cliente_apellido != null) 
    		return reclamoRepository.findByKeywords(cliente_nombre, cliente_apellido);
    		
    	return reclamoRepository.findAll();
    	
//    	if (cliente_nombre != null && cliente_apellido != null) {
//			return reclamoRepository.findByClienteQueReclama_NombreAndClienteQueReclama_Apellido(cliente_nombre, cliente_apellido);
//		}
//    	
//		if (cliente_nombre != null) {
//			return reclamoRepository.findByClienteQueReclama_Nombre(cliente_nombre);
//		}
//		
//		if (cliente_apellido != null) {
//			return reclamoRepository.findByClienteQueReclama_Apellido(cliente_apellido);
//		}
//    	
//        return reclamoRepository.findAll();
    }
	
    public Reclamo create(ReclamoDto reclamoDto) throws Exception {

        Reclamo reclamoEntity = reclamoMapper.fromDto(reclamoDto);

        reclamoEntity.setEstado(EnumEstadoReclamo.INICIADO);

        return reclamoRepository.save(reclamoEntity);
    }
    
    public Reclamo updateReclamo(Long reclamoId, ReclamoDto reclamoDto) throws Exception {
        Reclamo reclamoEntity = reclamoRepository.findById(reclamoId).orElseThrow(() -> new Exception("Error"));

        reclamoEntity = reclamoMapper.merger(reclamoDto, reclamoEntity);

        return reclamoRepository.save(reclamoEntity);
    }
    
    public void deleteById(Long reclamoId) throws Exception {
        reclamoRepository.deleteById(reclamoId);
    }
    
	
    public List<Reclamo> findByPrioridad(EnumPrioridad prioridad){
    	return reclamoRepository.findByPrioridad(prioridad);
    }
}
