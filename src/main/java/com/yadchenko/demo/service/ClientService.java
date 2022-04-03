package com.yadchenko.demo.service;

import com.yadchenko.demo.model.Client;

import java.util.List;

public interface ClientService {
    Client add(Client client);

    List<Client> getAll();

    void delete(Long id);
}
