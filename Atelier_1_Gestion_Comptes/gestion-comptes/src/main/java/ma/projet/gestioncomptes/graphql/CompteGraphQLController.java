
package ma.projet.gestioncomptes.graphql;

import ma.projet.gestioncomptes.dtos.CompteRequestDTO;
import ma.projet.gestioncomptes.dtos.CompteResponseDTO;
import ma.projet.gestioncomptes.entities.TypeCompte;
import ma.projet.gestioncomptes.services.CompteService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

// Contrôleur responsable des requêtes GraphQL
@Controller
public class CompteGraphQLController {

    private final CompteService compteService;

    // Injection de notre couche Service métier
    public CompteGraphQLController(CompteService compteService) {
        this.compteService = compteService;
    }

    // QUERY : récupérer tous les comptes
    @QueryMapping
    public List<CompteResponseDTO> comptes() {
        return compteService.getTousLesComptes();
    }

    // QUERY : rechercher un compte par son ID
    @QueryMapping
    public CompteResponseDTO compte(@Argument String id) {
        return compteService.getCompteParId(
                Long.parseLong(id)
        );
    }

    // Convertir LocalDate en String pour GraphQL
    @SchemaMapping(typeName = "Compte", field = "dateCreation")
    public String dateCreation(CompteResponseDTO compte) {
        return compte.getDateCreation().toString();
    }

    // MUTATION : créer un compte
    @MutationMapping
    public CompteResponseDTO creerCompte(
            @Argument double solde,
            @Argument TypeCompte type) {

        CompteRequestDTO dto =
                new CompteRequestDTO(solde, type);

        return compteService.ajouterCompte(dto);
    }

    // MUTATION : modifier un compte
    @MutationMapping
    public CompteResponseDTO modifierCompte(
            @Argument String id,
            @Argument double solde,
            @Argument TypeCompte type) {

        CompteRequestDTO dto =
                new CompteRequestDTO(solde, type);

        return compteService.modifierCompte(
                Long.parseLong(id), dto
        );
    }

    // MUTATION : supprimer un compte
    @MutationMapping
    public boolean supprimerCompte(@Argument String id) {

        compteService.supprimerCompte(
                Long.parseLong(id)
        );

        return true;
    }
}
