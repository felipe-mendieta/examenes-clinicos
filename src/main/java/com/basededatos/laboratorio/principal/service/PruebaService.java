package com.basededatos.laboratorio.principal.service;



import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Prueba;

import java.util.List;

public interface PruebaService {

    public List<Prueba> listAllPrueba();

    public Prueba getPrueba(Long id);

    public Prueba createPrueba(Prueba Prueba);
    public Prueba updatePrueba(Prueba Prueba);
    public Prueba deletePrueba(Long id);

    public List<Prueba> findbyArea(Area area);
    public List<Prueba> findbyTitulo(Area area);


}
