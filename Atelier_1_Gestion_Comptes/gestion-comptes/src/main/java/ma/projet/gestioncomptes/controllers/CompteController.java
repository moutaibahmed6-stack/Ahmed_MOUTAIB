
package ma.projet.gestioncomptes.controllers;

import ma.projet.gestioncomptes.dtos.CompteRequestDTO;
import ma.projet.gestioncomptes.dtos.CompteResponseDTO;
import ma.projet.gestioncomptes.services.CompteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    private final CompteService compteService;

    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    // GET : tous les comptes
    @GetMapping
    public List<CompteResponseDTO> getTousLesComptes() {
        return compteService.getTousLesComptes();
    }

    // GET : compte par ID
    @GetMapping("/{id}")
    public CompteResponseDTO getCompteParId(
            @PathVariable Long id) {

        return compteService.getCompteParId(id);
    }

    // POST : créer un compte
    @PostMapping
    public ResponseEntity<CompteResponseDTO> ajouterCompte(
            @RequestBody CompteRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(compteService.ajouterCompte(dto));
    }

    // PUT : modifier un compte
    @PutMapping("/{id}")
    public CompteResponseDTO modifierCompte(
            @PathVariable Long id,
            @RequestBody CompteRequestDTO dto) {

        return compteService.modifierCompte(id, dto);
    }

    // DELETE : supprimer un compte
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCompte(
            @PathVariable Long id) {

        compteService.supprimerCompte(id);
        return ResponseEntity.noContent().build();
    }
}
