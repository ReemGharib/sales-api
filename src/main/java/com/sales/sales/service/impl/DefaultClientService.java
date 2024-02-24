package com.sales.sales.service.impl;

import com.sales.sales.dto.ClientDto;
import com.sales.sales.exception.ClientNotFoundException;
import com.sales.sales.model.Client;
import com.sales.sales.repository.ClientRepository;
import com.sales.sales.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

/**
 * @author Reem Gharib
 */
@Service
@RequiredArgsConstructor
public class DefaultClientService implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }

    @Override
    public Client createClient(ClientDto clientDto) {

        Client client = Client.builder()
                .name(clientDto.getName())
                .lastName(clientDto.getLastName())
                .mobile(clientDto.getMobile())
                .build();

        clientRepository.save(client);

        return client;
    }

    @Override
    public Client updateClient(ClientDto clientDto, String id) {

        Client client = this.clientRepository.findById(Long.valueOf(id)).orElseThrow(
                () -> new ClientNotFoundException(format("Client not found by id : %s", id)));

        client.setName(clientDto.getName());
        client.setLastName(clientDto.getLastName());
        client.setMobile(clientDto.getMobile());

        return client;
    }
}
