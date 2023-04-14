package com.example.soapp.controlleur;

import com.example.soapp.model.Evenement;
import com.example.soapp.service.EvenementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evenement")
public class EvenementControler {

    @Autowired
    private EvenementService evenementService;

    @GetMapping
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
    @ApiOperation(value = "Recherche les evenements classés par jour",
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
    public List<Evenement> recherchePourAsso(String nom) {
        return evenementService.recherchePourAsso(nom);
    }

}