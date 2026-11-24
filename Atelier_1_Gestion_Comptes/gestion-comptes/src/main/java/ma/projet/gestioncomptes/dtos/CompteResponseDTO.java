
package ma.projet.gestioncomptes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.projet.gestioncomptes.entities.TypeCompte;

import java.time.LocalDate;

// Informations retournées au client
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteResponseDTO {

    private Long id;

    private double solde;

    private LocalDate dateCreation;

    private TypeCompte type;
}
