
package ma.projet.gestioncomptes.services;

import ma.projet.gestioncomptes.dtos.CompteRequestDTO;
import ma.projet.gestioncomptes.dtos.CompteResponseDTO;

import java.util.List;

// Contrat des opérations métier sur les comptes
public interface CompteService {

    // Récupérer tous les comptes
    List<CompteResponseDTO> getTousLesComptes();

    // Rechercher un compte
    CompteResponseDTO getCompteParId(Long id);

    // Créer un compte
    CompteResponseDTO ajouterCompte(CompteRequestDTO dto);

    // Modifier un compte
    CompteResponseDTO modifierCompte(
            Long id, CompteRequestDTO dto);

    // Supprimer un compte
    void supprimerCompte(Long id);
}
