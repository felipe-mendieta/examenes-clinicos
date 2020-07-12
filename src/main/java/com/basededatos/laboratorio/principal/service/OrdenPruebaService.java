package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.*;

import java.sql.Date;
import java.util.List;

public interface OrdenPruebaService {
    public List<OrdenPrueba> listAllOrdenPrueba();

    public OrdenPrueba getOrdenPrueba(Long idOrden, Long idPrueba);
    public List<OrdenPrueba> getOrdenPruebaByEntity(Orden orden);

    public OrdenPrueba getOrdenPruebaBothEntities(Orden orden, Prueba prueba);
    public List<OrdenPrueba> getOrdenPruebaOrdenId(Long idOrden);

    public OrdenPrueba createOrdenPrueba(OrdenPrueba ordenPrueba);

    public OrdenPrueba deleteOrdenPrueba(Long idOrden, Long idPrueba);


}
