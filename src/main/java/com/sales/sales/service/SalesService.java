package com.sales.sales.service;

import com.sales.sales.dto.SalesDto;
import com.sales.sales.model.Sale;

import java.util.List;

/**
 * @author Reem Gharib
 */
public interface SalesService {

    /**
     * Retrieve all sales
     *
     * @return array of sale
     */
    List<Sale> getAllSales();

    /**
     * Create Sale with multiple transactions
     *
     * @param salesDto the sales dto
     * @return sales dto
     */
    SalesDto createSale(SalesDto salesDto);
}
