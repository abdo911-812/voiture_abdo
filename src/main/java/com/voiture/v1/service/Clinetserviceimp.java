package com.voiture.v1.service;


import com.voiture.v1.entity.Client;
import com.voiture.v1.repository.Clientrepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Clinetserviceimp implements Clientservice{

    private final Clientrepo clientrepo;

    public Clinetserviceimp(Clientrepo clientrepo) {
        this.clientrepo = clientrepo;
    }

    @Override
    public List<Client> getAllClients() {
        return  clientrepo.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientrepo.findById(id);
    }

    @Override
    @Transactional
    public Client saveClient(Client client) {
        return clientrepo.save(client);
    }

    @Override
    @Transactional
    public Client updateClient(Client client, Long id) {

        if(clientrepo.existsById(id)){
            throw new RuntimeException("clinet avec id "+id+"non trouve");
        }
        return  clientrepo.save(client);
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        if(!clientrepo.existsById(id)){
            throw new RuntimeException("clinet avec id "+id+"non trouve");
        }else{
            clientrepo.deleteById(id);
        }

    }
}
