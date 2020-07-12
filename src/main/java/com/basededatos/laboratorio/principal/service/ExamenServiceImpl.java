package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Examen;
import com.basededatos.laboratorio.principal.entity.Orden;
import com.basededatos.laboratorio.principal.repository.ExamenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamenServiceImpl implements ExamenService{

    private final ExamenRepository examenRepository;

    @Override
    public List<Examen> listAllExamen() {
        return examenRepository.findAll();
    }

    @Override
    public List<Examen> getExamenesPaciente(String id) { //Lista de examenes de un paciente
        return examenRepository.findByIdPaciente(id);
    }

    @Override
    public Examen getLastExamen(String id) { //Unicamente ultimo examen
        return examenRepository.findAllByIdPacienteLast(id);
    }

    @Override
    public Examen getExamen(Long id) {
        return examenRepository.findById(id).orElse(null);
    }

    @Override
    public Examen findbyOrden(Orden orden) { //Busca por orden
        return examenRepository.findByOrden(orden);
    }

    @Override
    public List<Examen> findbyIdPaciente(String idPaciente) {
        return examenRepository.findByIdPaciente(idPaciente);
    }

    @Override
    public Examen createExamen(Examen examen) {
        examen.setStatus("CREATED");
        examen.setCreateAt(new java.util.Date());
        return examenRepository.save(examen);
    }


    @Override
    public Examen updateExamen(Examen examen) {
        Examen examenDB = getExamen(examen.getId());
        if (null == examenDB){
            return null;
        }

        examenDB.setNombreLaboratorista(examen.getNombreLaboratorista());
        return examenRepository.save(examenDB);
    }

    @Override
    public Examen deleteExamen(Long id) {
        Examen examenDB = getExamen(id);
        if (null == examenDB){
            return null;
        }

        examenDB.setStatus("DELETED");

        return examenRepository.save(examenDB);
    }






}
