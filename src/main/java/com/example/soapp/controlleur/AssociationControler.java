package com.example.soapp.controlleur;

import com.example.soapp.model.Association;
import com.example.soapp.service.AssociationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/association")
public class AssociationControler {

    @Autowired
    AssociationService associationService;

    @GetMapping
    @ApiOperation(value = "Recherche par id",
            notes = "Cette methode recherche une association en fonction de son id")
    public Association research(@RequestParam("id") Long id) {
        return associationService.research(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retourne toutes les associations",
            notes = "Cette methode permet de rechercher toutes les associations")
    public List<Association> getAllAssociation() {
        return associationService.getAllAssociation();
    }

    @PostMapping
    @ApiOperation(value = "Creation d'une association",
            notes = "Cette methode permet de creer une association")
    public Association creerAssociation(@RequestBody Association association) {
        return associationService.creerAssociation(association);
    }

    @PatchMapping
    @ApiOperation(value = "Modification d'une association",
            notes = "Cette methode permet de modifier une association")
    public Association modifier(@RequestBody Association association, @RequestParam("id") Long id) {
        return associationService.modifier(association, id);
    }

    @DeleteMapping
    @ApiOperation(value = "Suppression d'une association",
            notes = "Cette methode permet de supprimer une association")
    public String supprimer(@RequestParam("id") Long id) {
        return associationService.supprimer(id);
    }

}