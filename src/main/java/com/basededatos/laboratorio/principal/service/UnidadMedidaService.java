package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.UnidadMedida;

import java.util.List;

public interface UnidadMedidaService {
    public List<UnidadMedida> listAllUnidadMedida();

    public UnidadMedida getUnidadMedida(Long id);

    public UnidadMedida createUnidadMedida(UnidadMedida unidadMedida);
    public UnidadMedida updateUnidadMedida(UnidadMedida unidadMedida);
    public UnidadMedida deleteUnidadMedida(Long id);

    public UnidadMedida findByName(String name);
    public UnidadMedida updateName(Long id, String name);


}
