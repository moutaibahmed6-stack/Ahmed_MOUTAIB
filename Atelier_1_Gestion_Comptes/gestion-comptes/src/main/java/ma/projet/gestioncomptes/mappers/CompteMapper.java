
package ma.projet.gestioncomptes.mappers;

import ma.projet.gestioncomptes.dtos.CompteRequestDTO;
import ma.projet.gestioncomptes.dtos.CompteResponseDTO;
import ma.projet.gestioncomptes.entities.Compte;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

// Spring gère automatiquement cet objet Mapper
@Component
public class CompteMapper {

    // Convertir le DTO de création en entité Compte
    public Compte toEntity(CompteRequestDTO dto) {

        return new Compte(
                null,
                dto.getSolde(),
                LocalDate.now(),
                dto.getType()
        );
    }

    // Convertir l'entité Compte en DTO de réponse
    public CompteResponseDTO toDTO(Compte compte) {

        return new CompteResponseDTO(
                compte.getId(),
                compte.getSolde(),
                compte.getDateCreation(),
                compte.getType()
        );
    }
}
