package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Orden;
import com.basededatos.laboratorio.principal.entity.OrdenPrueba;
import com.basededatos.laboratorio.principal.entity.Prueba;
import com.basededatos.laboratorio.principal.entity.Resultado;
import com.basededatos.laboratorio.principal.repository.OrdenPruebaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenPruebaServiceImplementation implements OrdenPruebaService{

    private final OrdenPruebaRepository ordenPruebaRepository;


    @Override
    public List<OrdenPrueba> listAllOrdenPrueba() {
        return ordenPruebaRepository.findAll();
    }

    @Override
    public OrdenPrueba getOrdenPrueba(Long idOrden, Long idPrueba) {
        return ordenPruebaRepository.findByIds(idOrden, idPrueba);
    }

    @Override
    public List<OrdenPrueba> getOrdenPruebaByEntity(Orden orden) {
        //return ordenPruebaRepository.findByOrden(orden);
        return null;
    }

    @Override
    public OrdenPrueba getOrdenPruebaBothEntities(Orden orden, Prueba prueba) {
        //return ordenPruebaRepository.findByOrdenAAndPrueba(orden,prueba);
        return null;
    }

    @Override
    public List<OrdenPrueba> getOrdenPruebaOrdenId(Long idOrden) {
        return ordenPruebaRepository.findByidOrden(idOrden);
    }

    @Override
    public OrdenPrueba createOrdenPrueba(OrdenPrueba ordenPrueba) {
        ordenPrueba.setStatus("CREATED");
        return ordenPruebaRepository.save(ordenPrueba);

    }


    @Override
    public OrdenPrueba deleteOrdenPrueba(Long idOrden, Long idPrueba) {
        OrdenPrueba ordenPruebaDB = getOrdenPrueba(idOrden, idPrueba);
        if (null == ordenPruebaDB){
            return null;
        }
        return ordenPruebaRepository.save(ordenPruebaDB);
    }

}
