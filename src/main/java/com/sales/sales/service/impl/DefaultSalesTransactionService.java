package com.sales.sales.service.impl;

import com.sales.sales.dto.SaleTransactionDto;
import com.sales.sales.model.SaleTransaction;
import com.sales.sales.repository.SalesTransactionRepository;
import com.sales.sales.service.SalesTransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class DefaultSalesTransactionService implements SalesTransactionService {

    @Autowired
    private SalesTransactionRepository salesTransactionRepository;

    @Override
    public void updateSaleTransaction(SaleTransactionDto saleTransaction, String saleTransactionId) {

        log.info("Updating sale transaction with id " + saleTransactionId);

        SaleTransaction saleTransactionOptional = salesTransactionRepository
                .findById(Long.valueOf(saleTransactionId))
                .orElseThrow(() -> new IllegalArgumentException("Sales Transaction Not Found"));

        saleTransaction.setPrice(saleTransaction.getPrice());
        saleTransaction.setQuantity(saleTransaction.getQuantity());

        salesTransactionRepository.save(saleTransactionOptional);

        log.info("Successfully updated sale transaction with id " + saleTransactionId);
    }
}
