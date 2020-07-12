package com.basededatos.laboratorio.principal.controller;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Examen;
import com.basededatos.laboratorio.principal.entity.Prueba;
import com.basededatos.laboratorio.principal.entity.UnidadMedida;
import com.basededatos.laboratorio.principal.service.ExamenService;
import com.basededatos.laboratorio.principal.service.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/examenes")
public class ExamenController {

    @Autowired
    private ExamenService examenService;



    @GetMapping()
    public ResponseEntity<List<Examen>> listExamen(@RequestParam(name = "idPaciente", required = false) String idPaciente){
        List<Examen> examenes = new ArrayList<>();

        if(null==idPaciente){
            examenes=examenService.listAllExamen();
            if(examenes.isEmpty()){
                return ResponseEntity.noContent().build();
            }

        }else{
            examenes=examenService.findbyIdPaciente(idPaciente);
            if(examenes.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }


        return ResponseEntity.ok(examenes);
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<Examen> getExamen(@PathVariable("id") Long id){
        Examen examen= examenService.getExamen(id);
        if(null==examen){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(examen);
    }


    @PostMapping
    public ResponseEntity<Examen> createExamen(@RequestBody Examen examen){
        Examen examenCeate=examenService.createExamen(examen);
        return ResponseEntity.status(HttpStatus.CREATED).body(examenCeate);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Examen> deleteExamen(@PathVariable("id") Long id){
        Examen examenDelete = examenService.deleteExamen(id);
        if (examenDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(examenDelete);
    }


}
