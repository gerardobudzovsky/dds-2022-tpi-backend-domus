package com.frre.utn.domus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.frre.utn.domus.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long>{
	
	@Query("SELECT c FROM Cita c WHERE CONCAT(c.nombreSolicitante, ' ', c.observaciones, ' ' , c.propiedad.calle, ' ', c.propiedad.numero) LIKE %:keyword%")
	List<Cita> findByKeyword(String keyword);
	
	List<Cita> findByNombreSolicitanteAndObservaciones(String nombreSolicitante, String observaciones);
	
	List<Cita> findByNombreSolicitante(String nombreSolicitante);
	
	List<Cita> findByObservaciones(String observaciones);
	
	List<Cita> findByPropiedad_Id(Long id);
	
	List<Cita> findByPropiedad_Calle(String calle);
	
	List<Cita> findByPropiedad_CalleAndPropiedad_Numero(String calle, Integer numero);

	List<Cita> findByPropiedad_Numero(Integer propiedad_numero);


	

	
}
