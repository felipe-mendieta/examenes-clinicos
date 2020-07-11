package com.basededatos.laboratorio.principal.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable

public class OrdenPruebaId implements Serializable {
    private Long idOrden;

    private Long idPrueba;

    public OrdenPruebaId(){

    }
    public OrdenPruebaId(Long idOrden, Long idprueba){
        this.idOrden=idOrden;
        this.idPrueba=idprueba;
    }

}
