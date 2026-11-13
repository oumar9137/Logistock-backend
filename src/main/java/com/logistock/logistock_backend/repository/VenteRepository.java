package com.logistock.logistock_backend.repository;
import com.logistock.logistock_backend.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface VenteRepository extends JpaRepository<Vente, Integer> {
    List<Vente> findAllByOrderByDateVenteDesc();
}