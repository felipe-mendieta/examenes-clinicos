package com.basededatos.laboratorio.principal.repository;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {

    public List<Prueba> findByArea(Area area);

    @Query(value = "select pru from prueba pru where pru.titulo like '%keyword%'", nativeQuery = true)
    public List<Prueba> findByTitulo(@Param("keyword") String titulo);

    public List<Prueba> findByTituloContaining(String titulo);
}
