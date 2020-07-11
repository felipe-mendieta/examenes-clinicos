package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.UnidadMedida;
import com.basededatos.laboratorio.principal.repository.AreaRepository;
import com.basededatos.laboratorio.principal.repository.UnidadMedidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UnidadMedidaServiceImpl implements UnidadMedidaService{

    private final UnidadMedidaRepository unidadMedidaRepository;


    @Override
    public List<UnidadMedida> listAllUnidadMedida() {
        return unidadMedidaRepository.findAll();
    }

    @Override
    public UnidadMedida getUnidadMedida(Long id) {
        return unidadMedidaRepository.findByid(id);
    }

    @Override
    public UnidadMedida createUnidadMedida(UnidadMedida unidadMedida) {
        unidadMedida.setStatus("CREATED");
        unidadMedida.setCreateAt(new Date());
        return unidadMedidaRepository.save(unidadMedida);
    }

    @Override
    public UnidadMedida updateUnidadMedida(UnidadMedida unidadMedida) {
        UnidadMedida unidadDeMedidaDB = getUnidadMedida(unidadMedida.getId());
        if (null == unidadDeMedidaDB){
            return null;
        }
        unidadDeMedidaDB.setUnidadDeMedida(unidadMedida.getUnidadDeMedida());
        return unidadMedidaRepository.save(unidadDeMedidaDB);
    }

    @Override
    public UnidadMedida deleteUnidadMedida(Long id) {
        UnidadMedida unidadDeMedidaDB = getUnidadMedida(id);
        if (null == unidadDeMedidaDB){
            return null;
        }
        unidadDeMedidaDB.setStatus("DELETED");
        return unidadMedidaRepository.save(unidadDeMedidaDB);
    }

    @Override
    public UnidadMedida updateName(Long id, String nombreUnidad) {

        UnidadMedida unidadDeMedidaDB = getUnidadMedida(id);
        if (null == unidadDeMedidaDB){
            return null;
        }
        unidadDeMedidaDB.setUnidadDeMedida(nombreUnidad);
        return unidadMedidaRepository.save(unidadDeMedidaDB);

    }
}
