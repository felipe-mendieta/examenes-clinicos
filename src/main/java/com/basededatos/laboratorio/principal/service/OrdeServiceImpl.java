package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Orden;
import com.basededatos.laboratorio.principal.repository.AreaRepository;
import com.basededatos.laboratorio.principal.repository.OrdenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrdeServiceImpl implements OrdenService{

    private final OrdenRepository ordenRepository;



    @Override
    public List<Orden> listAllOrden() {
        return ordenRepository.findAll();
    }

    @Override
    public Orden getOrden(Long id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    public Orden createOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public Orden updateOrden(Orden orden) {
        return null;
    }

    @Override
    public Orden deleteOrden(Long id) {
        return null;
    }

    @Override
    public List<Orden> findbyPaciente(String idPaciente) {
        return null;
    }

    @Override
    public List<Orden> findbyMedicoSolicitante(String idPaciente) {
        return null;
    }

    @Override
    public List<Orden> findbyCreated(Date fecha) {
        return null;
    }
}
