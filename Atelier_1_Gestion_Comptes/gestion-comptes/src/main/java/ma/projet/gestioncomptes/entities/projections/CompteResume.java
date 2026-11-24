
package ma.projet.gestioncomptes.entities.projections;

import ma.projet.gestioncomptes.entities.Compte;
import org.springframework.data.rest.core.config.Projection;

// Projection contenant uniquement ID et solde
@Projection(name = "resume", types = Compte.class)
public interface CompteResume {

    Long getId();

    double getSolde();
}
