package com.basededatos.laboratorio.principal.service;


import com.basededatos.laboratorio.principal.entity.Orden;

import java.sql.Date;
import java.util.List;

public interface OrdenService {
    public List<Orden> listAllOrden();

    public Orden getOrden(Long id);

    public Orden createOrden(Orden orden);
    public Orden updateOrden(Orden orden);
    public Orden deleteOrden(Long id);

    public List<Orden> findbyPaciente(String idPaciente);
    public Orden findbyPacienteLast(String idPaciente);
    public Orden disposeOrden(Long id);
}
