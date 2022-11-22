package com.frre.utn.domus.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.frre.utn.domus.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query("SELECT c FROM Cliente c "
			+ "WHERE CONCAT(c.nombre, ' ') LIKE %:nombre% "
			+ "AND "
			+ "CONCAT(c.apellido, ' ') LIKE %:apellido%"
		  )
	List<Cliente> findByKeywords(String nombre, String apellido);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO cliente_propiedad (cliente_id, propiedad_id) VALUES (?1, ?2)", nativeQuery = true)
	void vincularPropiedad(Long clienteId, Long propiedadId);

}
