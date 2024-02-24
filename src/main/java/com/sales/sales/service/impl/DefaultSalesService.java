package com.sales.sales.service.impl;

import com.sales.sales.dto.SaleTransactionDto;
import com.sales.sales.dto.SalesDto;
import com.sales.sales.model.*;
import com.sales.sales.repository.*;
import com.sales.sales.service.SalesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Reem Gharib
 */
@Log4j2
@RequiredArgsConstructor
@Service
public class DefaultSalesService implements SalesService {

    private final SalesRepository salesRepository;
    private final ClientRepository clientRepository;
    private final SellerRepository sellerRepository;
    private final ProductRepository productRepository;
    private final SalesTransactionRepository salesTransactionRepository;

    @Override
    public List<Sale> getAllSales() {

        return this.salesRepository.findAll();
    }

    @Override
    public SalesDto createSale(SalesDto salesDto) {

        log.info("Attempting to creat sales");

        Client client = clientRepository.findById(Long.valueOf(salesDto.getClientId()))
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        Seller seller = sellerRepository.findById(Long.valueOf(salesDto.getSellerId()))
                .orElseThrow(() -> new IllegalArgumentException("Seller not found"));

        double total = salesDto.getSaleTransactions()
                .stream()
                .mapToDouble(transaction -> transaction.getPrice() * transaction.getQuantity())
                .sum();

        log.info("Total sale transactions: [{}] associated to client [{}] and Seller : [{}]",
                total, salesDto.getClientId(), salesDto.getSellerId());

        salesDto.setTotal(total);

        Sale sale = Sale.builder()
                .creationDate(LocalDateTime.now())
                .total(total)
                .client(client)
                .seller(seller)
                .build();

        this.salesRepository.save(sale);

        for (SaleTransactionDto saleTransactionDto : salesDto.getSaleTransactions()) {

            Product product = this.productRepository.findById(Long.valueOf(saleTransactionDto.getProductId()))
                    .orElseThrow(() -> new IllegalArgumentException("Product not found"));

            SaleTransaction saleTransaction = SaleTransaction.builder()
                    .price(saleTransactionDto.getPrice())
                    .quantity(saleTransactionDto.getQuantity())
                    .product(product)
                    .sale(sale)
                    .build();

            this.salesTransactionRepository.save(saleTransaction);
        }

        return salesDto;
    }
}
