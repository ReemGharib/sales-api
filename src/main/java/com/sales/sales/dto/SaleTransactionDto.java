package com.sales.sales.dto;

import lombok.*;

/**
 * @author reem gh
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SaleTransactionDto {

    private int quantity;
    private double price;
    private String productId;
}
