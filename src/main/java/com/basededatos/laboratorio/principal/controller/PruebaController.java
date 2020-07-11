package com.basededatos.laboratorio.principal.controller;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Prueba;
import com.basededatos.laboratorio.principal.service.AreaService;
import com.basededatos.laboratorio.principal.service.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pruebas")
public class PruebaController {

    @Autowired
    private PruebaService pruebaService;

    @GetMapping()
    public ResponseEntity<List<Prueba>> listPrueba(){
        List<Prueba> pruebas= pruebaService.listAllPrueba();

        if(pruebas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pruebas);
    }

    @PostMapping
    public ResponseEntity<Prueba> createPrueba(@RequestBody Prueba prueba){
        Prueba pruebaCreate=pruebaService.createPrueba(prueba);
        return ResponseEntity.status(HttpStatus.CREATED).body(pruebaCreate);
    }
}
