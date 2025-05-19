package com.voiture.v1.service;

import com.voiture.v1.entity.Client;

import java.util.List;
import java.util.Optional;

public interface Clientservice {

    List<Client>  getAllClients();

    Optional<Client> getClientById(Long id);

    Client saveClient(Client client);

    Client updateClient(Client client, Long id);

    void deleteClient(Long id);

}
