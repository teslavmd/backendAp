package com.backend.backendAp.models.skill;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") @Getter @Setter
    private int id;


    @Column(name = "titulo", nullable = false) @Getter @Setter
    private String titulo;


    @Column(name = "img_url", nullable = false) @Getter @Setter
    private String img_url;


    @Column(name = "progreso", nullable = false) @Getter @Setter
    private int progreso;




}
