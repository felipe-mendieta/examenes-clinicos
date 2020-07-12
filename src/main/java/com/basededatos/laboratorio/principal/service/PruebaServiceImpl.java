package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Prueba;
import com.basededatos.laboratorio.principal.repository.PruebaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PruebaServiceImpl implements PruebaService{

    private final PruebaRepository pruebaRepository;

    @Override
    public List<Prueba> listAllPrueba() {
        return pruebaRepository.findAll();
    }

    @Override
    public Prueba getPrueba(Long id) {
        return pruebaRepository.findById(id).orElse(null);
    }

    @Override
    public Prueba createPrueba(Prueba prueba) {
        prueba.setStatus("CREATED");
        prueba.setCreateAt(new java.util.Date());
        return pruebaRepository.save(prueba);

    }

    @Override
    public Prueba updatePrueba(Prueba prueba) {
        Prueba pruebaDB = getPrueba(prueba.getId());
        if (null == pruebaDB){
            return null;
        }
        pruebaDB.setTitulo(prueba.getTitulo());
        pruebaDB.setPrecio(prueba.getPrecio());
        pruebaDB.setLimiteInferior(prueba.getLimiteInferior());
        pruebaDB.setLimiteSuperior(prueba.getLimiteSuperior());
        prueba.setArea(prueba.getArea());

        return pruebaRepository.save(pruebaDB);
    }

    @Override
    public Prueba deletePrueba(Long id) {
        Prueba pruebaDB = getPrueba(id);
        if (null == pruebaDB){
            return null;
        }
        pruebaDB.setStatus("DELETED");
        return pruebaRepository.save(pruebaDB);
    }

    @Override
    public List<Prueba> findbyArea(Long idArea) {

        return pruebaRepository.findByIdArea(idArea);
    }

    @Override
    public List<Prueba> findbyTitulo(String titulo) {
        return pruebaRepository.findByTitulo(titulo);
    }
}
