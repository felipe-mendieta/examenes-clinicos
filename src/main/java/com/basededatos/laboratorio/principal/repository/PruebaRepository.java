package com.basededatos.laboratorio.principal.repository;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.hibernate.dialect.PostgreSQL10Dialect;

import java.util.List;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {

    @Query(value = "select * from prueba pru where pru.id_area=?1", nativeQuery = true)
    public List<Prueba> findByIdArea(Long idArea);

    @Query(value = "SELECT * FROM prueba pru WHERE LOWER(pru.titulo) ILIKE LOWER('%blancos%')", nativeQuery = true)
    public List<Prueba> findByTitulo(@Param("keyword") String titulo);
}
