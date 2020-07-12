package com.basededatos.laboratorio.principal.controller;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Examen;
import com.basededatos.laboratorio.principal.entity.Orden;
import com.basededatos.laboratorio.principal.entity.Prueba;
import com.basededatos.laboratorio.principal.service.OrdenService;
import com.basededatos.laboratorio.principal.service.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping()
    public ResponseEntity<List<Orden>> listPrueba(@RequestParam(name = "idPaciente", required = false) String idPaciente){
        List<Orden> ordenes= new ArrayList<>();
        if (null==idPaciente){
            ordenes=ordenService.listAllOrden();
            if(ordenes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }else{
                ordenes= ordenService.findbyPaciente(idPaciente);
            if(ordenes.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(ordenes);
    }

    @GetMapping(value = "/{orden}")
    public ResponseEntity<Orden> getOrden(@PathVariable("id") Long id){
        Orden orden= ordenService.getOrden(id);
        if(null==orden){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orden);
    }

    @PostMapping
    public ResponseEntity<Orden> createOrden(@RequestBody Orden orden){
        Orden ordenCreate=ordenService.createOrden(orden);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenCreate);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Orden> deleteOrden(@PathVariable("id") Long id){
        Orden ordenDelete = ordenService.deleteOrden(id);
        if (ordenDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ordenDelete);
    }
}
