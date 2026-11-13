package com.logistock.logistock_backend.repository;
import com.logistock.logistock_backend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<Client, Integer> {}