package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Orden;
import com.basededatos.laboratorio.principal.entity.OrdenPrueba;

import java.sql.Date;
import java.util.List;

public interface OrdenPruebaService {
    public List<OrdenPrueba> listAllOrdenPrueba();

    public OrdenPrueba getOrdenPrueba(Long idOrden, Long idPrueba);

    public OrdenPrueba createOrdenPrueba(OrdenPrueba ordenPrueba);
    public OrdenPrueba updateOrdenPrueba(OrdenPrueba ordenPrueba);
    public OrdenPrueba deleteOrdenPrueba(Long idOrden, Long idPrueba);

    public List<OrdenPrueba> findbyOrdenPrueba(Long idOrden);

}
