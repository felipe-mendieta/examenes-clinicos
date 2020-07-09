package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Area;

import com.basededatos.laboratorio.principal.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



//Inyeccion de dependencias
@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService{



    private final AreaRepository areaRepository;
    @Override
    public List<Area> listAllArea() {
        return areaRepository.findAll();
    }

    @Override
    public Area findByName(String name) {
        return null;
    }

    @Override
    public Area getArea(Long id) {
        return null;
    }

    @Override
    public Area createArea(Area area) {
        area.setStatus("CREATED");
        area.setCreateAt(new Date());

        return areaRepository.save(area);
    }

    @Override
    public Area updateArea(Area area) {
        return null;
    }

    @Override
    public Area deleteArea(Long id) {
        return null;
    }
}
