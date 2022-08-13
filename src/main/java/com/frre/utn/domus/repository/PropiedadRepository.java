package com.frre.utn.domus.repository;

import com.frre.utn.domus.entity.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO ver si usamos paginado mas tarde
@Repository
public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {

}
