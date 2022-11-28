package com.backend.backendAp.models.projects;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;


    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "tecnologias")
    @Getter @Setter
    private String tecnologias;

    @Column(name = "descripcion")
    @Getter @Setter
    private String descripcion;

    @Column(name = "url_git")
    @Getter @Setter
    private String url_git;

    @Column(name = "url_web")
    @Getter @Setter
    private String url_web;


}
