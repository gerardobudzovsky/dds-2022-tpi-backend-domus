package com.frre.utn.domus.repository;

import com.frre.utn.domus.entity.Propiedad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {
	
	List<Propiedad> findByClientes_Id(Long clienteId);
}
