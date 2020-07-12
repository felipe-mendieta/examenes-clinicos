package com.basededatos.laboratorio.principal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Entity
@Table(name = "prueba")
//Generar los metodos princiaples getters setters tostring stc
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @NotEmpty(message = "El nombre no debe ser vacío")
    private String titulo;


    private Double precio;

    private Float limiteInferior;

    private Float limiteSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idArea", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idUnidad", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private UnidadMedida unidadMedida;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    private String status;


}
