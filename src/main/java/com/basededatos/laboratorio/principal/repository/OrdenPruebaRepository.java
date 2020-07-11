package com.basededatos.laboratorio.principal.repository;

import com.basededatos.laboratorio.principal.entity.Orden;
import com.basededatos.laboratorio.principal.entity.OrdenPrueba;
import com.basededatos.laboratorio.principal.entity.OrdenPruebaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenPruebaRepository extends JpaRepository<OrdenPrueba, Long> {

public List<OrdenPrueba> findByOrden(Orden orden);

}
