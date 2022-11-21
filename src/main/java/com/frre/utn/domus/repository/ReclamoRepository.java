package com.frre.utn.domus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.frre.utn.domus.entity.Reclamo;
import com.frre.utn.domus.utils.EnumPrioridad;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Long>{
	
	List<Reclamo> findByPrioridad(EnumPrioridad prioridad);
	
	List<Reclamo> findByClienteQueReclama_Nombre(String nombre);
	
	List<Reclamo> findByClienteQueReclama_Apellido(String apellido);
	
	List<Reclamo> findByClienteQueReclama_NombreAndClienteQueReclama_Apellido(String nombre, String apellido);
	
	@Query("SELECT r FROM Reclamo r "
			+ "WHERE CONCAT(r.clienteQueReclama.nombre) LIKE %:nombre%"
			+ " AND "
			+ "CONCAT(r.clienteQueReclama.apellido) LIKE %:apellido%"
		  )
	List<Reclamo> findByKeywords(String nombre, String apellido);
	
}
