package com.basededatos.laboratorio.principal.controller;
import com.basededatos.laboratorio.principal.entity.Orden;
import com.basededatos.laboratorio.principal.entity.Prueba;

import com.basededatos.laboratorio.principal.service.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pruebas")
public class PruebaController {

    @Autowired
    private PruebaService pruebaService;

    @GetMapping()
    public ResponseEntity<List<Prueba>> listPrueba(@RequestParam(name = "titulo", required = false) String titulo){
        List<Prueba> pruebas = new ArrayList<>();
        System.out.println(titulo);
        if(null==titulo){
            pruebas=pruebaService.listAllPrueba();
            if(pruebas.isEmpty()){
                return ResponseEntity.noContent().build();
            }

        }else{
            pruebas=pruebaService.findbyTitulo(titulo);
            if(pruebas.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }


        return ResponseEntity.ok(pruebas);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Prueba> getPrueba(@PathVariable("id") Long id){
        Prueba prueba= pruebaService.getPrueba(id);
        if(null==prueba){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(prueba);
    }

    @GetMapping(value = "/area/{id}")
    public ResponseEntity<List<Prueba>> getPruebaArea(@PathVariable("id") Long idArea){
        List<Prueba> prueba= pruebaService.findbyArea(idArea);
        if(null==prueba){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(prueba);
    }

    @PostMapping
    public ResponseEntity<Prueba> createPrueba(@RequestBody Prueba prueba){
        Prueba pruebaCreate=pruebaService.createPrueba(prueba);
        return ResponseEntity.status(HttpStatus.CREATED).body(pruebaCreate);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Prueba> deletePrueba(@PathVariable("id") Long id){
        Prueba pruebaDelete = pruebaService.deletePrueba(id);
        if (pruebaDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pruebaDelete);
    }
}
