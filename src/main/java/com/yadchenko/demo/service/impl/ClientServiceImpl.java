package com.yadchenko.demo.service.impl;

import com.yadchenko.demo.model.Client;
import com.yadchenko.demo.repository.ClientRepository;
import com.yadchenko.demo.service.ClientService;
import com.yadchenko.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ProductService productService;

    @Override
    public Client add(Client client) {
        Client currentClient =  clientRepository.findById(client.getId()).orElseGet(Client::new);
        currentClient.setName(client.getName());
        currentClient.setAddress(client.getAddress());
        currentClient.setPhone(client.getPhone());
        currentClient.setProducts(
                client.getProducts().stream()
                        .map(productService::recountProduct)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
        return currentClient;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
