package com.basededatos.laboratorio.principal.service;


import com.basededatos.laboratorio.principal.entity.Producto;


import java.util.List;

public interface ProductoService {

    public List<Producto> findbyCategorias();

    public String findMultimedia(Long id);

}
