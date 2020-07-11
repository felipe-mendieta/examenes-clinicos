package com.basededatos.laboratorio.principal.service;


import com.basededatos.laboratorio.principal.entity.Examen;

import java.sql.Date;
import java.util.List;

public interface ExamenService {
    public List<Examen> listAllExamen();

    public Examen getExamen(Long id);

    public Examen createExamen(Examen examen);
    public Examen updateExamen(Examen examen);
    public Examen deleteExamen(Long id);

    public List<Examen> findbyPaciente(String idPaciente);
    public List<Examen> findbyOrden(String idPaciente);
    public List<Examen> findbyCreated(Date fecha);

}
