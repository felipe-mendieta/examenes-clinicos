package com.basededatos.laboratorio.principal.repository;

import com.basededatos.laboratorio.principal.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenPruebaRepository extends JpaRepository<OrdenPrueba, Long> {

    //public List<OrdenPrueba> findByOrden(Orden orden);

    @Query(value="select ord from orden_prueba ord where ord.idOrden=?1 order by create_at desc", nativeQuery = true)
    public List<OrdenPrueba> findByidOrden(Long idOrden);


    //public OrdenPrueba findByOrdenAAndPrueba(Orden orden, Prueba prueba);

    @Query(value="select ord from orden_prueba ord where ord.idOrden=?1 and ord.idPrueba=?2 order by create_at desc", nativeQuery = true)
    public OrdenPrueba findByIds(Long idOrden, Long idPrueba);


}
