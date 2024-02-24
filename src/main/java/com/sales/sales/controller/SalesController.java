package com.sales.sales.controller;

import com.sales.sales.dto.SalesDto;
import com.sales.sales.model.Sale;
import com.sales.sales.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Reem Gharib
 */
@RequestMapping("sales")
@Controller
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {

        return new ResponseEntity<>(this.salesService.getAllSales(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SalesDto> createSales(@RequestBody SalesDto salesDto) {

        return new ResponseEntity<>(this.salesService.createSale(salesDto), HttpStatus.CREATED);
    }


}
