package com.basededatos.laboratorio.principal.service;

import com.basededatos.laboratorio.principal.entity.Examen;
import com.basededatos.laboratorio.principal.entity.Prueba;
import com.basededatos.laboratorio.principal.entity.Resultado;
import com.basededatos.laboratorio.principal.repository.ResultadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultadoServiceImpl implements ResultadoService {

    private final ResultadoRepository resultadoRepository;


    @Override
    public List<Resultado> listAllResultado() {
        return resultadoRepository.findAll();
    }

    @Override
    public Resultado getResultado(Long idExamen, Long idPrueba) { //Resultado individual por ids
        return resultadoRepository.findByIds(idExamen,idPrueba);
    }

    @Override
    public List<Resultado> getResultadoExamen(Examen examen) { //Todos resultados por entidad examen
        return resultadoRepository.findByExamen(examen);
    }

    @Override
    public List<Resultado> getResultadoExamenId(Long idExamen) { //Todos resultados por id Examen
        return resultadoRepository.findByidExamen(idExamen);
    }

    @Override
    public Resultado getResultadoEntidades(Examen examen, Prueba prueba) {
        return resultadoRepository.findByExamenAndPrueba(examen,prueba);
    }

    @Override
    public Resultado createResultado(Resultado resultado) {
        resultado.setStatus("CREATED");
        return resultadoRepository.save(resultado);
    }

    @Override
    public Resultado updateResultado(Resultado resultado) {
        Resultado resultadoDB = getResultadoEntidades(resultado.getExamen(), resultado.getPrueba());
        if (null == resultadoDB){
            return null;
        }
        resultadoDB.setValor(resultado.getValor());
        return resultadoRepository.save(resultadoDB);
    }

    @Override
    public Resultado deleteResultado(Long idExamen, Long idPrueba) {
        Resultado resultadoDB = getResultado(idExamen, idPrueba);
        if (null == resultadoDB){
            return null;
        }
        resultadoDB.setStatus("DELETED");

        return resultadoRepository.save(resultadoDB);
    }
}
