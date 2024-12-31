package com.example.tpmanytomany.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Getter @Setter
public class Command {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommand;
    private Long montant;

    @ManyToMany(fetch = FetchType.EAGER)        //Par défaut  (fetch = FetchType.EAGER)
    /*
    @JoinTable (name="Command_Client_Jointure",
            joinColumns =  @JoinColumn (name="idCommand"),
            inverseJoinColumns = @JoinColumn (name="IdClient"))
*/
    // @ManyToMany(mappedBy = "commandes")
    List<Client> clients = new ArrayList<>();
}
