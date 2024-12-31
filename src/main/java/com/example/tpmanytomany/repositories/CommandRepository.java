package com.example.tpmanytomany.repositories;

import com.example.tpmanytomany.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Long> {
}
