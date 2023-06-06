package com.example.soapp.controlleur;

import com.example.soapp.model.Association;
import com.example.soapp.model.Etudiant;
import com.example.soapp.model.Evenement;
import com.example.soapp.service.EtudiantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/etudiant")
public class EtudiantControler {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping
    @ApiOperation(value = "Creation d'un etudiant",
            notes = "Cette methode permet de creer un etudiant")
    public Etudiant creerEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.creerEtudiant(etudiant);
    }

    @GetMapping
    @ApiOperation(value = "Recherche par id",
            notes = "Cette methode recherche un etudiant en fonction de son id")
    public Optional<Etudiant> research(@RequestParam("id") Long id) {
        return etudiantService.rechercheParId(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retourne toutes les etudiants",
            notes = "Cette methode permet de rechercher toutes les etudiants")
    public List<Etudiant> getAllEtudiant() {
        return etudiantService.getEtudiant();
    }

    @PatchMapping
    @ApiOperation(value = "Modification d'un etudiant",
            notes = "Cette methode permet de modifier un etudiant")
    public Etudiant modifier(@RequestBody Etudiant etudiant, @RequestParam("id") Long id) {
        return etudiantService.modifier(etudiant, id);
    }
    @DeleteMapping
    @ApiOperation(value = "Suppression d'une etudiant",
            notes = "Cette methode permet de supprimer un etudiant")
    public String supprimer(@RequestParam("id") Long id) {
        return etudiantService.supprimer(id);
    }

}
