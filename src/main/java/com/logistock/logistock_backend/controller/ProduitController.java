package com.logistock.logistock_backend.controller;
import com.logistock.logistock_backend.entity.Produit;
import com.logistock.logistock_backend.repository.ProduitRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins = "*")
public class ProduitController {
    private final ProduitRepository repo;
    public ProduitController(ProduitRepository repo){this.repo=repo;}
    @GetMapping public List<Produit> all(){return repo.findAll();}
    @GetMapping("/{id}") public Produit one(@PathVariable Integer id){return repo.findById(id).orElseThrow();}
    @PostMapping public Produit create(@RequestBody Produit p){return repo.save(p);}
    @PutMapping("/{id}") public Produit update(@PathVariable Integer id, @RequestBody Produit nouveau){
        Produit p = repo.findById(id).orElseThrow();
        p.setReference(nouveau.getReference());
        p.setDesignation(nouveau.getDesignation());
        p.setPrix(nouveau.getPrix());
        p.setStock(nouveau.getStock());
        p.setSeuil(nouveau.getSeuil());
        p.setCategorie(nouveau.getCategorie());
        return repo.save(p);
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Integer id){repo.deleteById(id);}
}