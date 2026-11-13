package com.logistock.logistock_backend.controller;
import com.logistock.logistock_backend.entity.*;
import com.logistock.logistock_backend.repository.*;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController @RequestMapping("/api/ventes") @CrossOrigin("*")
public class VenteController {
    private final VenteRepository venteRepo;
    private final ProduitRepository produitRepo;
    private final ClientRepository clientRepo;
    private final UtilisateurRepository utilisateurRepo;

    public VenteController(VenteRepository v, ProduitRepository p, ClientRepository c, UtilisateurRepository u){
        this.venteRepo=v; this.produitRepo=p; this.clientRepo=c; this.utilisateurRepo=u;
    }

    @GetMapping public List<Vente> liste(){ return venteRepo.findAllByOrderByDateVenteDesc(); }

    @PostMapping
    public Vente vendre(@RequestBody Map<String,Object> body){
        Integer idProduit = Integer.valueOf(body.get("idProduit").toString());
        Integer quantite = Integer.valueOf(body.get("quantite").toString());
        Integer idClient = Integer.valueOf(body.get("idClient").toString());
        Integer idUtilisateur = Integer.valueOf(body.get("idUtilisateur").toString());

        Produit p = produitRepo.findById(idProduit).orElseThrow();
        // Vérifie le stock avec TON vrai nom : getStock()
        if(p.getStock() < quantite) throw new RuntimeException("Stock insuffisant ! Il reste " + p.getStock());

        // 1. Diminue le stock tout seul avec setStock()
        p.setStock(p.getStock() - quantite);
        produitRepo.save(p);

        // 2. Crée la vente
        Vente v = new Vente();
        v.setNumero("VT-" + System.currentTimeMillis());
        v.setProduit(p);
        v.setQuantite(quantite);
        v.setClient(clientRepo.findById(idClient).orElseThrow());
        v.setUtilisateur(utilisateurRepo.findById(idUtilisateur).orElseThrow());
        v.setMontantTotal(p.getPrix().multiply(BigDecimal.valueOf(quantite)));
        v.setDateVente(LocalDateTime.now());
        return venteRepo.save(v);
    }
}