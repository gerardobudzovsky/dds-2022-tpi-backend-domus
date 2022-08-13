package com.frre.utn.domus.service;

import com.frre.utn.domus.dto.PropiedadDto;
import com.frre.utn.domus.entity.Propiedad;
import com.frre.utn.domus.repository.PropiedadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PropiedadService {

    private PropiedadRepository propiedadRepository;

    @Autowired
    public PropiedadService(PropiedadRepository propiedadRepository) {
        this.propiedadRepository = propiedadRepository;
    }

    public Propiedad getPropiedadById(Long idPropiedad) throws Exception {
        return propiedadRepository.findById(idPropiedad).orElseThrow(() -> new Exception("Error"));
    }

    public List<Propiedad> getAllPropiedad() throws Exception {
        return propiedadRepository.findAll();
    }

    public Propiedad createPropiedad(PropiedadDto dto) throws Exception {
        // TODO cambiar esto por Mapstruct
        Propiedad entity = Propiedad.builder()
                .barrio(dto.getBarrio())
                .calle(dto.getCalle())
                .ciudad(dto.getCiudad())
                .descripcionBreve(dto.getDescripcionBreve())
                .descripcionDetallada(dto.getDescripcionDetallada())
                .espacios(dto.getEspacios())
                .estado(dto.getEstado())
                .fechaConstruccion(dto.getFechaConstruccion())
                .numero(dto.getNumero())
                .pais(dto.getPais())
                .propietario(dto.getPropietario())
                .provincia(dto.getProvincia())
                .tipo(dto.getTipo())
                .build();

        return propiedadRepository.save(entity);
    }

    public Propiedad updatePropiedad(Long idPropiedad, PropiedadDto dto) throws Exception {
        Propiedad entity = propiedadRepository.findById(idPropiedad).orElseThrow(() -> new Exception("Error"));

        entity.setBarrio(dto.getBarrio());
        entity.setCalle(dto.getCalle());
        entity.setCiudad(dto.getCiudad());
        entity.setDescripcionBreve(dto.getDescripcionBreve());
        entity.setDescripcionDetallada(dto.getDescripcionDetallada());
        entity.setEspacios(dto.getEspacios());
        entity.setEstado(dto.getEstado());
        entity.setFechaConstruccion(dto.getFechaConstruccion());
        entity.setNumero(dto.getNumero());
        entity.setPais(dto.getPais());
        entity.setPropietario(dto.getPropietario());
        entity.setProvincia(dto.getProvincia());
        entity.setTipo(dto.getTipo());

        return propiedadRepository.save(entity);
    }

    public void deletePropiedadById(Long idPropiedad) throws Exception {
        propiedadRepository.deleteById(idPropiedad);
    }
}
