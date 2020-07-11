package com.basededatos.laboratorio.principal.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "ordenPrueba")
//Generar los metodos princiaples getters setters tostring stc
@Data @AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenPrueba {

    @EmbeddedId //Definir clave principal compuesta con atributos de ordenPruebaId
    private OrdenPruebaId ordenPruebaId;

    private String status;

    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="idPrueba", referencedColumnName = "id", insertable=false, updatable=false)
    private Prueba prueba;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="idOrden", referencedColumnName = "id", insertable=false, updatable=false)
    private Orden orden;



}



