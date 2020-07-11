package com.basededatos.laboratorio.principal.repository;


import com.basededatos.laboratorio.principal.entity.Resultado;
import com.basededatos.laboratorio.principal.entity.ResultadoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, ResultadoId> {

    public List<Resultado> findByExamen(Long idexamen);
}
