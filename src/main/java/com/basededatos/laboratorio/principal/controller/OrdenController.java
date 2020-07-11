package com.basededatos.laboratorio.principal.controller;

import com.basededatos.laboratorio.principal.entity.Orden;
import com.basededatos.laboratorio.principal.entity.Prueba;
import com.basededatos.laboratorio.principal.service.OrdenService;
import com.basededatos.laboratorio.principal.service.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping()
    public ResponseEntity<List<Orden>> listPrueba(){
        List<Orden> ordenes= ordenService.listAllOrden();

        if(ordenes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ordenes);
    }



    @PostMapping
    public ResponseEntity<Orden> createOrden(@RequestBody Orden orden){
        Orden ordenCreate=ordenService.createOrden(orden);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenCreate);
    }
}
