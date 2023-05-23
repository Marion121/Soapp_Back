package com.example.soapp.controlleur;

import com.example.soapp.model.Etudiant;
import com.example.soapp.model.Evenement;
import com.example.soapp.service.EvenementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evenement")
public class EvenementControler {

    @Autowired
    private EvenementService evenementService;

    @GetMapping()
    @ApiOperation(value = "Recherche les evenement par id",
            notes = "Cette methode permet de rechercher tous les évènements pour un id donne")
    public Optional<Evenement> rechercheParId(@RequestParam("id") Long id) {
        return evenementService.rechercheParId(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Recherche de tous les évènements",
            notes = "Cette methode permet de rechercher tous les évènements")
    public List<Evenement> getEvenements() {
        return evenementService.getEvenements();
    }

    @GetMapping("/jour")
    @ApiOperation(value = "Recherche les evenement par jour",
            notes = "Cette methode permet de rechercher tous les évènements pour un jour donne")
    public List<Evenement> rechercheParJour(int jour) {
        return evenementService.rechercheParJour(jour);
    }

    @PostMapping
    @ApiOperation(value = "Creation d'un évènement",
            notes = "Cette methode permet de creer un évènement")
    public Evenement creerEvenement(@RequestBody Evenement evenement) {
        return evenementService.creerEvenement(evenement);
    }

    // Marche pas, pas sur que cela se fasse
    @GetMapping("/calendrier")
    @ApiOperation(value = "Recherche les evenements classés par mois",
            notes = "Cette methode permet de rechercher tous les évènements classer par jour")
    public List<Evenement> rechercheCalendrier(int mois) {
        return evenementService.rechercheCalendrier(mois);
    }
         //Voir si on en fait une juste pour la validation
    @PatchMapping
    @ApiOperation(value = "Modification d'un evenement",
            notes = "Cette methode permet de modifier un evenement")
    public Evenement modifier(@RequestBody Evenement evenement, @RequestParam("id") Long id) {
        return evenementService.modifier(evenement, id);
    }

    @GetMapping("/feed")
    @ApiOperation(value = "Recherche les evenements pour Feed",
            notes = "Cette methode permet de rechercher tous les évènements pour le feed")
    public List<Evenement> rechercheFeed() {
        return evenementService.rechercheFeed();
    }

    @GetMapping("/asso")
    @ApiOperation(value = "Recherche les evenements pour une asso",
            notes = "Cette methode permet de rechercher tous les évènements pour une asso")
    public List<Evenement> recherchePourAsso(Long id) {
        return evenementService.recherchePourAsso(id);
    }
    
    @DeleteMapping
    @ApiOperation(value = "Suppression d'une evenement",
            notes = "Cette methode permet de supprimer un evenement")
    public String supprimer(@RequestParam("id") Long id) {return evenementService.supprimer(id);}

    @PostMapping("/like")
    @ApiOperation(value = "liker un evenement",
            notes = "Cette methode permet de liker un evenement")
    public String like(@RequestParam("idEvent") Long EvenementId, @RequestParam("idStudent") Long idEtudiant) {
        return evenementService.like(EvenementId,idEtudiant);
    }

    @DeleteMapping("/dislike")
    @ApiOperation(value = "supprimer le like un evenement",
            notes = "Cette methode permet de supprimer le liker un evenement")
        public String dislike(@RequestParam("idEvent") Long EvenementId, @RequestParam("idStudent") Long idEtudiant) {
        return evenementService.dislike(EvenementId,idEtudiant);
    }
}
