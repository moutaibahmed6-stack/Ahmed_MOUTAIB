
package ma.projet.gestioncomptes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.projet.gestioncomptes.entities.TypeCompte;

// Données nécessaires pour créer ou modifier un compte
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteRequestDTO {

    private double solde;

    private TypeCompte type;
}
