package com.basededatos.laboratorio.principal.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basededatos.laboratorio.principal.entity.Producto;
import com.basededatos.laboratorio.principal.service.ProductoService;

@RestController
@RequestMapping(value = "/productos")
public class ProductoController {

    @Autowired
    private ProductoService ProductoService;
    
    @GetMapping()
    public ResponseEntity<List<Producto>> listPrueba(){
        List<Producto> productos= ProductoService.findbyCategorias();
        
        return ResponseEntity.ok(productos);
    }


}
