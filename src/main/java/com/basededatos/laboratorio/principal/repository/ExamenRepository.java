package com.basededatos.laboratorio.principal.repository;


import com.basededatos.laboratorio.principal.entity.Examen;

import com.basededatos.laboratorio.principal.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenRepository  extends JpaRepository<Examen, Long> {

    //Busqueda de todos los examenes mediante cedula del paciente
    public List<Examen> findByIdPaciente(String idPaciente);

    //Busqueda de ultimo examen realizado mediante cedula del paciente
    @Query(value="select exa from examen exa where exa.idPaciente=?1 order by create_at desc limit 1", nativeQuery = true)
    public Examen findAllByIdPacienteLast(String idPaciente);

    //Busqueda mediante la orden que creo el examen
    public Examen findByOrden(Orden orden);

}
