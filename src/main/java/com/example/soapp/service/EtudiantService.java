package com.example.soapp.service;

import com.example.soapp.model.Association;
import com.example.soapp.model.Etudiant;
import com.example.soapp.model.Evenement;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {

    Etudiant creerEtudiant(Etudiant etudiant);

    Optional<Etudiant> rechercheParId(Long id);

    List<Etudiant> getEtudiant();

    String supprimer(Long id);

    Etudiant modifier(Etudiant etudiant, Long id);
}
