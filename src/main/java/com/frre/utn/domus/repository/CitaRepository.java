package com.frre.utn.domus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frre.utn.domus.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long>{

}
