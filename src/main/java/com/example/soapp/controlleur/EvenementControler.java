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

    @PostMapping
    public Evenement creerEvenement(@RequestBody Evenement evenement) {
        return evenementService.creerEvenement(evenement);
    }
}
