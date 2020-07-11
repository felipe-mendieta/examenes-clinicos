package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService{

    private final AreaRepository areaRepository;


    @Override
    public List<Area> listAllArea() {
        return areaRepository.findAll();
    }

    @Override
    public Area getArea(Long id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public Area createArea(Area area) {
        area.setStatus("CREATED");

        return areaRepository.save(area);
    }

    @Override
    public Area updateArea(Area area) {
        Area areaDB = getArea(area.getId());
        if (null == areaDB){
            return null;
        }
        areaDB.setId(area.getId());
        areaDB.setNombre(area.getNombre());
        return areaRepository.save(areaDB);
    }

    @Override
    public Area deleteArea(Long id) {
        Area areaDB = getArea(id);
        if (null == areaDB){
            return null;
        }
        areaDB.setStatus("DELETED");
        return areaRepository.save(areaDB);
    }


    @Override
    public Area findByNombre(String nombre) {
        return areaRepository.findByNombreContaining(nombre);
    }

    @Override
    public Area updateName(Long id, String nombre) {
        Area areaDB = getArea(id);
        if (null == areaDB){
            return null;
        }
        areaDB.setNombre(nombre);
        return areaRepository.save(areaDB);
    }
}
