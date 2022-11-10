package com.frre.utn.domus.service;

import com.frre.utn.domus.dto.PropiedadDto;
import com.frre.utn.domus.entity.Propiedad;
import com.frre.utn.domus.mapper.PropiedadMapper;
import com.frre.utn.domus.repository.PropiedadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PropiedadService {

    private PropiedadRepository propiedadRepository;
    private PropiedadMapper propiedadMapper;

    @Autowired
    public PropiedadService(PropiedadRepository propiedadRepository, PropiedadMapper propiedadMapper) {
        this.propiedadRepository = propiedadRepository;
        this.propiedadMapper = propiedadMapper;
    }

    public Propiedad getPropiedadById(Long idPropiedad) throws Exception {
        return propiedadRepository.findById(idPropiedad).orElseThrow(() -> new Exception("Error"));
    }

    public List<Propiedad> getAllPropiedades() throws Exception {
        return propiedadRepository.findAll();
    }

    public Propiedad createPropiedad(PropiedadDto dto) throws Exception {

        Propiedad entity = propiedadMapper.fromDto(dto);

        return propiedadRepository.save(entity);
    }

    public Propiedad updatePropiedad(Long idPropiedad, PropiedadDto dto) throws Exception {
        Propiedad entity = propiedadRepository.findById(idPropiedad).orElseThrow(() -> new Exception("Error"));

        entity = propiedadMapper.merger(dto, entity);

        return propiedadRepository.save(entity);
    }

    public void deletePropiedadById(Long idPropiedad) throws Exception {
        propiedadRepository.deleteById(idPropiedad);
    }
}
