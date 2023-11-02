package com.backend.backendAp.models.education;


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter @Setter
    private Integer id;

    @Column(name = "nombre", nullable = false)
    @Getter @Setter
    private String nombre;

    @Column(name = "fecha_inicio", nullable = false)
    @Getter @Setter
    private String fechaInicio;

    @Column(name = "fecha_final")
    @Getter @Setter
    private String fechaFinal;

    @Column(name = "orientacion", nullable = false)
    @Getter @Setter
    private String orientacion;
}
