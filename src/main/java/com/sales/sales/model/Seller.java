package com.sales.sales.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "lastname")
    private String lastName;

    private String mobile;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Sale sale;
}
