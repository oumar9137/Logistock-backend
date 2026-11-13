package com.logistock.logistock_backend.controller;
import com.logistock.logistock_backend.entity.Client;
import com.logistock.logistock_backend.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/clients") @CrossOrigin("*")
public class ClientController {
    private final ClientRepository repo;
    public ClientController(ClientRepository r){ this.repo=r; }
    @GetMapping public List<Client> liste(){ return repo.findAll(); }
    @PostMapping public Client ajouter(@RequestBody Client c){ return repo.save(c); }
}