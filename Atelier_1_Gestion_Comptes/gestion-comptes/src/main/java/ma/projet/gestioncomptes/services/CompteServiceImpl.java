
package ma.projet.gestioncomptes.services;

import ma.projet.gestioncomptes.dtos.CompteRequestDTO;
import ma.projet.gestioncomptes.dtos.CompteResponseDTO;
import ma.projet.gestioncomptes.entities.Compte;
import ma.projet.gestioncomptes.mappers.CompteMapper;
import ma.projet.gestioncomptes.repositories.CompteRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompteServiceImpl implements CompteService {

    private final CompteRepository repository;
    private final CompteMapper mapper;

    public CompteServiceImpl(
            CompteRepository repository,
            CompteMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    // Afficher tous les comptes
    @Override
    public List<CompteResponseDTO> getTousLesComptes() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    // Rechercher un compte par ID
    @Override
    public CompteResponseDTO getCompteParId(Long id) {
        Compte compte = trouverCompte(id);
        return mapper.toDTO(compte);
    }

    // Créer un compte
    @Override
    public CompteResponseDTO ajouterCompte(
            CompteRequestDTO dto) {

        verifierDonnees(dto);

        Compte compte = mapper.toEntity(dto);
        Compte enregistre = repository.save(compte);

        return mapper.toDTO(enregistre);
    }

    // Modifier un compte
    @Override
    public CompteResponseDTO modifierCompte(
            Long id, CompteRequestDTO dto) {

        verifierDonnees(dto);

        Compte compte = trouverCompte(id);

        compte.setSolde(dto.getSolde());
        compte.setType(dto.getType());

        Compte modifie = repository.save(compte);

        return mapper.toDTO(modifie);
    }

    // Supprimer un compte
    @Override
    public void supprimerCompte(Long id) {
        Compte compte = trouverCompte(id);
        repository.delete(compte);
    }

    // Rechercher le compte ou retourner une erreur 404
    private Compte trouverCompte(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Compte introuvable : " + id
                        )
                );
    }

    // Vérifier les règles métier
    private void verifierDonnees(CompteRequestDTO dto) {

        if (dto == null || dto.getType() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le type du compte est obligatoire"
            );
        }

        if (dto.getSolde() < 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le solde ne peut pas être négatif"
            );
        }
    }
}
