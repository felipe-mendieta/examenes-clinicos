package com.basededatos.laboratorio.principal.repository;

import com.basededatos.laboratorio.principal.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    public List<Orden> findByIdPaciente(Long idPaciente);
}
