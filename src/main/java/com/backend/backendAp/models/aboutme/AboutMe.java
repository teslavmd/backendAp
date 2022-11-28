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


    @Column(name = "texto", nullable = false)
    @Getter @Setter
    private String texto;

}
