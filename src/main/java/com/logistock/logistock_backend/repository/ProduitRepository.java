package com.logistock.logistock_backend.repository;
import com.logistock.logistock_backend.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProduitRepository extends JpaRepository<Produit, Integer> {}