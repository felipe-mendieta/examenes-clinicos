package com.basededatos.laboratorio.principal.controller;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Orden;
import com.basededatos.laboratorio.principal.entity.UnidadMedida;
import com.basededatos.laboratorio.principal.service.AreaService;
import com.basededatos.laboratorio.principal.service.UnidadMedidaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UnidadMedida> deleteUnidadMedida(@PathVariable("id") Long id){
        UnidadMedida unidadDelete = unidadMedidaService.deleteUnidadMedida(id);
        if (unidadDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(unidadDelete);
    }
    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
