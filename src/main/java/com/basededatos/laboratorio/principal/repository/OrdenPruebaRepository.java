package com.basededatos.laboratorio.principal.repository;

import com.basededatos.laboratorio.principal.entity.*;
import com.basededatos.laboratorio.principal.service.OrdenService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenPruebaRepository extends JpaRepository<OrdenPrueba, Long> {

    //public List<OrdenPrueba> findByOrden(Orden orden);

    @Query(value="select * from orden_prueba ord where ord.id_orden=?1", nativeQuery = true)
    public List<OrdenPrueba> findByidOrden(Long idOrden);


    //public OrdenPrueba findByOrdenAAndPrueba(Orden orden, Prueba prueba);

    @Query(value="select * from orden_prueba ord where ord.id_orden=?1 and ord.id_prueba=?2", nativeQuery = true)
    public OrdenPrueba findByIds(Long idOrden, Long idPrueba);

}