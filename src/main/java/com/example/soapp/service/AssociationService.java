package com.example.soapp.service;

import com.example.soapp.model.Association;
import com.example.soapp.model.Evenement;

import java.util.List;
import java.util.Optional;

public interface AssociationService {

    List<Association> getAllAssociation();

    Association creerAssociation(Association association);

    //Association research(Long id); // par id
    Optional<Association> rechercheParId(Long id);

    Association fav(Long idAsso, Long idEtudiant);

    String deletefav(Long idAsso, Long idEtudiant);

    Association modifier(Association association, Long id);

    String supprimer(Long id);

}
