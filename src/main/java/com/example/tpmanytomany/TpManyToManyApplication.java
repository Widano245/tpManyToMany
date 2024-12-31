package com.example.tpmanytomany;


import com.example.tpmanytomany.entities.Client;
import com.example.tpmanytomany.entities.Command;
import com.example.tpmanytomany.repositories.ClientRepository;
import com.example.tpmanytomany.repositories.CommandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TpManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpManyToManyApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			ClientRepository clientRespository, CommandRepository commandRespository) {
		return args -> {
		Client cl1= new Client(1L, "Houda",null);
		Client cl2= new Client(2L, "Lina",null);
		Client cl3= new Client(3L, "Mohamed",null);
		Client cl4= new Client(4L, "Amine",null);


		clientRespository.save(cl1);
		clientRespository.save(cl2);
		clientRespository.save(cl3);
		clientRespository.save(cl4);

		List<Client> list1= new ArrayList<>();
		list1.add(cl1);
		list1.add(cl2);

		commandRespository.save(new Command(1L, 1200L,list1));

		List<Client> list2= new ArrayList<>();
		list2.add(cl1);
		list2.add(cl3);
		commandRespository.save(new Command(2L, 2700L,list2));
		List<Client> list3= new ArrayList<>();
		list3.add(cl3);
		list3.add(cl4);
		commandRespository.save(new Command(3L,3400L,list3));

		// La liste des clients dans la commande 1L
		System.out.println("Listes de clients ayant la commande 1");
		Command cmm= commandRespository.findById(1L).get();
		System.out.println("Montant de la commande"+ cmm.getMontant());
		List<Client> l= cmm.getClients();
		for (Client c:l){
			System.out.println("Nom "+c.getNom());
		}

		//System.out.println("La liste des commandes du client 1L

		System.out.println("Listes de commande d'un client 1L");
		Client cll=  clientRespository.findById(1L).get();

		List<Command> listesCommandes = cll.getCommands();

		for (Command c:listesCommandes) {
			System.out.println(c.getMontant());
		}

	};
	}
}