package com.yadchenko.demo.controller;

import com.yadchenko.demo.model.Client;
import com.yadchenko.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping()
    public Client add(@RequestBody Client client) {
        return clientService.add(client);
    }

    @GetMapping()
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }
}
