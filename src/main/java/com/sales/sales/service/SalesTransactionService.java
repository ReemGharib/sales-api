package com.sales.sales.service;

import com.sales.sales.dto.SaleTransactionDto;

/**
 * @author Reem Gharib
 */
public interface SalesTransactionService {

    /**
     * Update sale transaction
     *
     * @param saleTransaction   the sale transaction dto
     * @param saleTransactionId the sale transaction id
     */
    void updateSaleTransaction(SaleTransactionDto saleTransaction, String saleTransactionId);
}
