package com.basededatos.laboratorio.principal.service;


import com.basededatos.laboratorio.principal.entity.Examen;
import com.basededatos.laboratorio.principal.entity.Orden;

import java.sql.Date;
import java.util.List;

public interface ExamenService {
    public List<Examen> listAllExamen();

    public List<Examen> getExamenesPaciente(String id);
    public Examen getLastExamen(String id);
    public Examen getExamen(Long id);

    public Examen createExamen(Examen examen);
    public Examen updateExamen(Examen examen);
    public Examen deleteExamen(Long id);

    public Examen findbyOrden(Orden orden);

}
