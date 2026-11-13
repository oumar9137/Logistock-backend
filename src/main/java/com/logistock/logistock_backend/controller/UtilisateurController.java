package com.logistock.logistock_backend.controller;

import com.logistock.logistock_backend.entity.Role;
import com.logistock.logistock_backend.entity.Utilisateur;
import com.logistock.logistock_backend.repository.RoleRepository;
import com.logistock.logistock_backend.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "*")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository repo;

    @Autowired
    private RoleRepository roleRepo;

    @GetMapping
    public List<Utilisateur> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Utilisateur creer(@RequestBody Utilisateur u) {
        // 1. On récupère le vrai Role depuis la base avec son id
        if (u.getRole() != null && u.getRole().getId() != null) {
            Role vraiRole = roleRepo.findById(u.getRole().getId()).orElseThrow(() -> new RuntimeException("Role introuvable"));
            u.setRole(vraiRole);
        }
        // 2. On met la date de création automatiquement
        if (u.getDateCreation() == null) {
            u.setDateCreation(LocalDateTime.now());
        }
        // 3. Si email vide, on met un email par défaut pour éviter le bug NOT NULL
        if (u.getEmail() == null || u.getEmail().isEmpty()) {
            u.setEmail(u.getNom().replace(" ", ".").toLowerCase() + "@logistock.ml");
        }
        return repo.save(u);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}