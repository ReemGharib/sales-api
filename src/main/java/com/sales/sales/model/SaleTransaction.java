package com.sales.sales.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author Reem Gh.
 */
@EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sale_transaction")
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    @JsonIgnore
    private Sale sale;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
