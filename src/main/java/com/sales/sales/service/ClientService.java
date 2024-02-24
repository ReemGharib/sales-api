package com.sales.sales.service;

import com.sales.sales.dto.ClientDto;
import com.sales.sales.model.Client;

import java.util.List;

/**
 * @author Reem Gharib
 */
public interface ClientService {

    List<Client> getAllClients();

    Client createClient(ClientDto clientDto);

    Client updateClient(ClientDto clientDto, String id);
}
