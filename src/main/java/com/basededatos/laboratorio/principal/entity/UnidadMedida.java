package com.basededatos.laboratorio.principal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "unidadMedida")
//Generar los metodos princiaples getters setters tostring etc con @Data es de loombok el plugin
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @NotEmpty(message = "La unidad de medida no debe ser vacía.")
    private String unidadDeMedida;

    private String status;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

}