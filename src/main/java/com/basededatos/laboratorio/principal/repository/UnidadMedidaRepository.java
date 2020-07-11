package com.basededatos.laboratorio.principal.repository;

import com.basededatos.laboratorio.principal.entity.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida, Long> {

public UnidadMedida findByid(Long id);

}
