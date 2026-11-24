
package ma.projet.gestioncomptes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Indique que cette classe représente une table
// dans notre base de données H2.
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {

    // Identifiant unique du compte
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Argent disponible sur le compte
    private double solde;

    // Date de création du compte
    private LocalDate dateCreation;

    // Enregistre le type sous forme de texte
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}
