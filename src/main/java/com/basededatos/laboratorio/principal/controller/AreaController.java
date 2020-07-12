package com.basededatos.laboratorio.principal.controller;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping()
    public ResponseEntity<List<Area>> listArea(){
        List<Area> areas= areaService.listAllArea();

        if(areas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(areas);
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<Area> getArea(@PathVariable("id") Long id){
        Area area= areaService.getArea(id);
        if(null==area){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(area);
    }


    @GetMapping(value = "/nombre/{nombre}")
    public ResponseEntity<Area> getAreaByNombre(@PathVariable("nombre") String nombre){
        Area area= areaService.findByNombre(nombre);
        if(null==area){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(area);
    }


    @PostMapping
    public ResponseEntity<Area> createArea(@RequestBody Area area){
        Area areaCreate=areaService.createArea(area);
        return ResponseEntity.status(HttpStatus.CREATED).body(areaCreate);
    }
}
