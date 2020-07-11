package com.basededatos.laboratorio.principal.repository;


import com.basededatos.laboratorio.principal.entity.Examen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenRepository  extends JpaRepository<Examen, Long> {


    public List<Examen> findByIdPaciente(Long idPaciente);

}
