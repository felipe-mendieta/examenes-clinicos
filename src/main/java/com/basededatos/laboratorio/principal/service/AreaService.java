package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Area;

import java.util.List;

public interface AreaService {
    public List<Area> listAllArea();
    public Area getArea(Long id);

    public Area createArea(Area area);
    public Area updateArea(Area area);
    public Area deleteArea(Long id);

    public Area findByNombre(String name);
    public Area updateName(Long id, String name);


}
