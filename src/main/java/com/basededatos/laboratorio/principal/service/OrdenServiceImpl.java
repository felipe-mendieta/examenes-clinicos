package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Orden;
import com.basededatos.laboratorio.principal.entity.UnidadMedida;
import com.basededatos.laboratorio.principal.repository.OrdenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrdenServiceImpl implements OrdenService{

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
        orden.setStatus("CREATED");
        orden.setCreateAt(new java.util.Date());
        return ordenRepository.save(orden);
    }

    @Override
    public Orden updateOrden(Orden orden) {

        Orden ordenDB = getOrden(orden.getId());
        if (null == ordenDB){
            return null;
        }

        ordenDB.setMedicoSolicitante(orden.getMedicoSolicitante());
        return ordenRepository.save(ordenDB);

    }

    @Override
    public Orden deleteOrden(Long id) {
        Orden ordenDB = getOrden(id);
        if (null == ordenDB){
            return null;
        }
        ordenDB.setStatus("DELETED");
        return ordenRepository.save(ordenDB);
    }

    @Override
    public List<Orden> findbyPaciente(String idPaciente) {

        return ordenRepository.findByIdPaciente(idPaciente);
    }

    @Override
    public Orden findbyPacienteLast(String idPaciente) {
        return ordenRepository.findAllByIdPacienteLast(idPaciente);
    }


    @Override
    public Orden disposeOrden(Long idOrden) {
        Orden ordenDB = getOrden(idOrden);
        if (null == ordenDB){
            return null;
        }
        ordenDB.setStatus("USED");
        return ordenRepository.save(ordenDB);

    }

}
