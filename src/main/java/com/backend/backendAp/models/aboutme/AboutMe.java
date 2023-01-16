package com.backend.backendAp.models.aboutme;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "aboutme")
public class AboutMe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter @Setter
    private Long id;


    @Column(name = "nombre", nullable = false)
    @Getter @Setter
    private String nombre;

    @Column(name = "apellido", nullable = false)
    @Getter @Setter
    private String apellido;

    @Column(name = "edad", nullable = false)
    @Getter @Setter
    private int edad;

    @Column(name = "fecha", nullable = false)
    @Getter @Setter
    private String fecha;

    @Column(name = "texto", nullable = false)
    @Getter @Setter
    private String texto;


}
