package com.basededatos.laboratorio.principal.service;



import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Prueba;

import java.util.List;

public interface PruebaService {

    public List<Prueba> listAllPrueba();

    public Prueba getPrueba(Long id);

    public Prueba createPrueba(Prueba prueba);
    public Prueba updatePrueba(Prueba prueba);
    public Prueba deletePrueba(Long id);

    public List<Prueba> findbyArea(Long idArea);
    public List<Prueba> findbyTitulo(String titulo);


}
