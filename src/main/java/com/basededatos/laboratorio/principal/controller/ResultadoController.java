package com.basededatos.laboratorio.principal.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.basededatos.laboratorio.principal.entity.Examen;
import com.basededatos.laboratorio.principal.entity.OrdenPrueba;
import com.basededatos.laboratorio.principal.entity.Resultado;
import com.basededatos.laboratorio.principal.service.OrdenPruebaService;
import com.basededatos.laboratorio.principal.service.PruebaService;
import com.basededatos.laboratorio.principal.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/resultados")
public class ResultadoController {


    @Autowired
    private ResultadoService resultadoService;

    @GetMapping()
    public ResponseEntity<List<Resultado>> listExamen(@RequestParam(name = "idExamen", required = false) Long idExamen){
        List<Resultado> resultados = new ArrayList<>();

        if(null==idExamen){
            resultados=resultadoService.listAllResultado();
            if(resultados.isEmpty()){
                return ResponseEntity.noContent().build();
            }

        }else{
            resultados=resultadoService.getResultadoExamenId(idExamen);
            if(resultados.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }


        return ResponseEntity.ok(resultados);
    }

    @GetMapping(value = "/{idExamen}/{idPrueba}")
    public ResponseEntity<Resultado> getOrdenPrueba(@PathVariable("idExamen") Long idExamen, @PathVariable("idPrueba") Long idPrueba){
        Resultado resultado= resultadoService.getResultado(idExamen,idPrueba);
        if(null==resultado){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Resultado> createOrdenPrueba(@RequestBody Resultado resultado){
        Resultado resultadoCreate=resultadoService.createResultado(resultado);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultadoCreate);

    }
}
