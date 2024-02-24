package com.sales.sales.dto;

import com.sales.sales.model.Client;
import com.sales.sales.model.Seller;
import lombok.*;

import java.util.List;

/**
 * @author reem gh
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SalesDto {

    private Double total;
    private String sellerId;
    private String clientId;
    private List<SaleTransactionDto> saleTransactions;
}
