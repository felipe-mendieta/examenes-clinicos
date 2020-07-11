package com.basededatos.laboratorio.principal.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ResultadoId implements Serializable {
    private Long idExamen;

    private Long idPrueba;

    public ResultadoId(){

    }

    public ResultadoId(Long idExamen, Long idprueba){
        this.idExamen=idExamen;
        this.idPrueba=idprueba;
    }
}
