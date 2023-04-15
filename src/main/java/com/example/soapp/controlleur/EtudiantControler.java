package com.example.soapp.controlleur;

import com.example.soapp.model.Etudiant;
import com.example.soapp.service.EtudiantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
