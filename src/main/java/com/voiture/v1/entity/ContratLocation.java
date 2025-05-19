package com.voiture.v1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ContratLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal( TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Temporal( TemporalType.TIMESTAMP)
    private Date dateFin;


    private String prixLoaction;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;
    @ManyToOne
    @JoinColumn(name = "Employee")
    private Employee employee;
}
