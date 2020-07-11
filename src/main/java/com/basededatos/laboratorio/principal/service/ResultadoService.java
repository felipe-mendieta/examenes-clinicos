package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Examen;
import com.basededatos.laboratorio.principal.entity.Prueba;
import com.basededatos.laboratorio.principal.entity.Resultado;

import java.util.List;

public interface ResultadoService {

    public List<Resultado> listAllResultado();

    public Resultado getResultado(Long idExamen, Long idPrueba);
    public List<Resultado> getResultadoExamen(Examen examen);

    public Resultado getResultadoEntidades(Examen examen, Prueba prueba);
    public List<Resultado> getResultadoExamenId(Long idExamen);


    public Resultado createResultado(Resultado prueba);
    public Resultado updateResultado(Resultado prueba);
    public Resultado deleteResultado(Long idExamen, Long idPrueba);

}
