package com.logistock.logistock_backend.controller;
import com.logistock.logistock_backend.entity.Utilisateur;
import com.logistock.logistock_backend.repository.UtilisateurRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final UtilisateurRepository repo;
    public AuthController(UtilisateurRepository repo){this.repo=repo;}
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,String> body){
        Map<String,Object> res = new HashMap<>();
        // On cherche par NOM, pas par email
        Optional<Utilisateur> opt = repo.findByNom(body.get("nom"));
        if(opt.isPresent() && opt.get().getMotDePasse().equals(body.get("motDePasse"))){
            Utilisateur u = opt.get();
            res.put("success", true);
            res.put("nom", u.getNom());
            res.put("email", u.getEmail());
            res.put("role", u.getRole().getLibelle());
            res.put("id", u.getId());
        } else {
            res.put("success", false);
            res.put("message", "Nom ou code incorrect");
        }
        return res;
    }
}