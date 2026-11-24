
package ma.projet.gestioncomptes.repositories;

import ma.projet.gestioncomptes.entities.Compte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "comptes",
        collectionResourceRel = "comptes"
)
public interface CompteRepository
        extends JpaRepository<Compte, Long> {

}
