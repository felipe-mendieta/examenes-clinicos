package com.basededatos.laboratorio.principal.service;


import java.util.List;


import com.basededatos.laboratorio.principal.entity.Producto;
import com.basededatos.laboratorio.principal.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor

public class ProductoServiceImpl implements ProductoService{

	private final ProductoRepository productoRepository; 

    @Override
    public List<Producto> findbyCategorias() {

        return (List<Producto>) productoRepository.findAllByIdCategorias();
    }

    @Override
    public String findMultimedia(Long id) {
        return productoRepository.findMultimedia(id);
    }


}
