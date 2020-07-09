package com.basededatos.laboratorio.principal.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "unidadMedida")
//Generar los metodos princiaples getters setters tostring etc con @Data es de loombok el plugin
@Data
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "La unidad de medida no debe ser vacía.")
    private String unidadDeMedida;





    private String status;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
}