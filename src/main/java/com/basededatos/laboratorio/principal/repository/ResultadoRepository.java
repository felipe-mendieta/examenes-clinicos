package com.basededatos.laboratorio.principal.repository;


import com.basededatos.laboratorio.principal.entity.Examen;
import com.basededatos.laboratorio.principal.entity.Prueba;
import com.basededatos.laboratorio.principal.entity.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {

    //Busqueda de resultado mediante entidad examen
    public List<Resultado> findByExamen(Examen examen);


    //Busqueda de Todos resultados por id del examen
    @Query(value="select * from resultado res where res.id_examen=?1 order by create_at desc", nativeQuery = true)
    public List<Resultado> findByidExamen(Long idExamen);

    //Busqueda resultado mediante entidades
    public Resultado findByExamenAndPrueba(Examen examen, Prueba prueba);


    //Busqueda resultado mediante ids de examen y prueba
    @Query(value="select * from resultado res where res.id_examen=?1 and res.id_prueba=?2 order by create_at desc", nativeQuery = true)
    public Resultado findByIds(Long idExamen, Long idPrueba);



}
