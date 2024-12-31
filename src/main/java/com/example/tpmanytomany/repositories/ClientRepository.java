package com.example.tpmanytomany.repositories;

import com.example.tpmanytomany.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
