package com.voiture.v1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;

    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
