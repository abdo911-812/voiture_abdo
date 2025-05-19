package com.voiture.v1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Data
public class Lesinfraction  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private String typeCharge;
    private String prixpay;
    private String image;

    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
