package com.voiture.v1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class EtatVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeoperation;
    private String imageDevent;
    private String imageArrier;
    private String imageGouche;
    private String imageDroit;
    private String kilometrage;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "contratlocation")
    private ContratLocation ContratLocation;


}
