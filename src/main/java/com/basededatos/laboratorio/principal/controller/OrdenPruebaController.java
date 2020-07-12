package com.basededatos.laboratorio.principal.controller;

import com.basededatos.laboratorio.principal.entity.Orden;
import com.basededatos.laboratorio.principal.entity.OrdenPrueba;
import com.basededatos.laboratorio.principal.entity.Resultado;
import com.basededatos.laboratorio.principal.service.OrdenPruebaService;
import com.basededatos.laboratorio.principal.service.OrdenService;
import com.basededatos.laboratorio.principal.service.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ordenpruebas")
public class OrdenPruebaController {

    @Autowired
    private OrdenPruebaService ordenPruebaService;

    @GetMapping
    public ResponseEntity<List<OrdenPrueba>> listExamen(@RequestParam(name = "idOrden", required = false) Long idOrden){
        List<OrdenPrueba> ordenPruebas = new ArrayList<>();

        if(null==idOrden){
            ordenPruebas=ordenPruebaService.listAllOrdenPrueba();
            if(ordenPruebas.isEmpty()){
                return ResponseEntity.noContent().build();
            }

        }else{
            ordenPruebas=ordenPruebaService.getOrdenPruebaOrdenId(idOrden);
            if(ordenPruebas.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }


        return ResponseEntity.ok(ordenPruebas);
    }

    @GetMapping(value = "/{idOrden}/{idPrueba}")
    public ResponseEntity<OrdenPrueba> getOrdenPrueba(@PathVariable("idOrden") Long idOrden, @PathVariable("idPrueba") Long idPrueba){
        OrdenPrueba ordenprueba= ordenPruebaService.getOrdenPrueba(idOrden,idPrueba);
        if(null==ordenprueba){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ordenprueba);
    }


    @PostMapping
    public ResponseEntity<OrdenPrueba> createOrdenPrueba(@RequestBody OrdenPrueba ordenPrueba){
        OrdenPrueba ordenpruebaCreate=ordenPruebaService.createOrdenPrueba(ordenPrueba);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenpruebaCreate);

    }

}


