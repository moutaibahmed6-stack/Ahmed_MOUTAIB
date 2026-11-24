
package ma.projet.gestioncomptes;

import ma.projet.gestioncomptes.entities.Compte;
import ma.projet.gestioncomptes.entities.TypeCompte;
import ma.projet.gestioncomptes.repositories.CompteRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class GestionComptesApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                GestionComptesApplication.class, args);
    }

    // Ce code s'exécute automatiquement
    // lorsque notre application démarre.
    @Bean
    CommandLineRunner testDAO(CompteRepository repository) {

        return args -> {

            // Création de trois comptes bancaires
            Compte compte1 = new Compte(
                    null,
                    5000.0,
                    LocalDate.now(),
                    TypeCompte.COURANT
            );

            Compte compte2 = new Compte(
                    null,
                    12000.0,
                    LocalDate.now(),
                    TypeCompte.EPARGNE
            );

            Compte compte3 = new Compte(
                    null,
                    7500.0,
                    LocalDate.now(),
                    TypeCompte.COURANT
            );

            // Enregistrement dans la base H2
            repository.save(compte1);
            repository.save(compte2);
            repository.save(compte3);

            // Affichage des comptes enregistrés
            System.out.println("===== LISTE DES COMPTES =====");

            repository.findAll().forEach(compte -> {
                System.out.println(
                        "ID : " + compte.getId()
                                + " | Solde : " + compte.getSolde()
                                + " | Date : " + compte.getDateCreation()
                                + " | Type : " + compte.getType()
                );
            });

            System.out.println("============================");
        };
    }
}
