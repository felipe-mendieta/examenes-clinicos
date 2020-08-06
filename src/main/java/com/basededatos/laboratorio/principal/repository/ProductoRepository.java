package com.basededatos.laboratorio.principal.repository;

import com.basededatos.laboratorio.principal.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	 public List<Producto> findByIdPacienteOrderByCreateAtDesc(String idPaciente);

    @Query(value="select * from productos pro where pro.id_categoria=1 and pro.id_subcategoria=1", nativeQuery = true)
    public List<Producto> findAllByIdCategorias();


}
