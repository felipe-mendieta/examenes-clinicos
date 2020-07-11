package com.basededatos.laboratorio.principal.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "resultado")
//Generar los metodos princiaples getters setters tostring stc
@Data @AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resultado {

    @EmbeddedId
    private ResultadoId resultado;



    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="idPrueba", referencedColumnName = "id", insertable=false, updatable=false)
    private Prueba prueba;

    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="idExamen", referencedColumnName = "id", insertable=false, updatable=false)
    private Examen examen;

    private String valor;

    private String status;

}
