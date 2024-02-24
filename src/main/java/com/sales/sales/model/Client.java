package com.sales.sales.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Reem Gh.
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Sale sale;
}
