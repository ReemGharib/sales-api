package com.sales.sales.controller;

import com.sales.sales.dto.SaleTransactionDto;
import com.sales.sales.service.SalesTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Reem Gharib
 */
@RequestMapping("sales/transaction")
@Controller
public class SalesTransactionController {

    @Autowired
    private SalesTransactionService salesTransactionService;

    @PutMapping("/{saleTransactionId}")
    public ResponseEntity<Void> updateSalesTransaction(@RequestBody SaleTransactionDto saleTransactionDto,
                                                       @PathVariable("saleTransactionId") String saleTransactionId) {

        this.salesTransactionService.updateSaleTransaction(saleTransactionDto, saleTransactionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
