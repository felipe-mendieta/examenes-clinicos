package com.basededatos.laboratorio.principal.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idOrden", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Orden orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idPrueba", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Prueba prueba;

    private String status;
}



