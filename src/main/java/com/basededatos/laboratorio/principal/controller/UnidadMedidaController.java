package com.basededatos.laboratorio.principal.controller;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.UnidadMedida;
import com.basededatos.laboratorio.principal.service.AreaService;
import com.basededatos.laboratorio.principal.service.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/unidades")
public class UnidadMedidaController {
    @Autowired
    private UnidadMedidaService unidadMedidaService;

    @GetMapping()
    public ResponseEntity<List<UnidadMedida>> listUnidad(){
        List<UnidadMedida> unidadMedidas= unidadMedidaService.listAllUnidadMedida();
        if(unidadMedidas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(unidadMedidas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnidadMedida> getArea(@PathVariable("id") Long id){
        UnidadMedida unidadMedidas= unidadMedidaService.getUnidadMedida(id);
        if(null==unidadMedidas){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(unidadMedidas);
    }


    @PostMapping
    public ResponseEntity<UnidadMedida> createUnidad(@RequestBody UnidadMedida unidad){
        UnidadMedida unidadCeate=unidadMedidaService.createUnidadMedida(unidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadCeate);
    }
}
