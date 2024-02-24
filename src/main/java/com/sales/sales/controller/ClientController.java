package com.sales.sales.controller;

import com.sales.sales.dto.ClientDto;
import com.sales.sales.model.Client;
import com.sales.sales.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Reem Gharib
 */
@RequestMapping("clients")
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {

        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody ClientDto client) {

        return new ResponseEntity<>(this.clientService.createClient(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody ClientDto client, @PathVariable(name = "id") String id) {

        return new ResponseEntity<>(this.clientService.updateClient(client, id), HttpStatus.CREATED);
    }
}
