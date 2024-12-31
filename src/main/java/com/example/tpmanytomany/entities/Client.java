package com.example.tpmanytomany.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Getter @Setter
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String nom;

    @ManyToMany(mappedBy = "clients", fetch = FetchType.EAGER)
    private List<Command> commands = new ArrayList<>();
}
