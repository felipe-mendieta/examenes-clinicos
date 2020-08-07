package com.basededatos.laboratorio.principal.repository;

import com.basededatos.laboratorio.principal.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {



    @Query(value="select * from productos pro where pro.id_categoria=1 and pro.id_subcategoria=25", nativeQuery = true)
    public List<Producto> findAllByIdCategorias();

    @Query(value="select multimedia from productos pro where pro.id=?1", nativeQuery = true)
    public String findMultimedia(Long id);


}
