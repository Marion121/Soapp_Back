package com.example.soapp.service;

import com.example.soapp.model.Etudiant;
import com.example.soapp.model.Evenement;

import java.util.List;
import java.util.Optional;


public interface EvenementService {

    List<Evenement> getEvenements();

    Evenement creerEvenement(Evenement evenement);

    Optional<Evenement> rechercheParId(Long id);

    List<Evenement> rechercheParJour(int jour, int mois);

    List<Evenement> rechercheCalendrier(int mois);

    Evenement modifier(Evenement evenement, Long id);

    String like(Long idEvenement, Long idEtudiant);

    String dislike(Long idEvenement, Long idEtudiant);

    List<Evenement> rechercheFeed();

    List<Evenement> recherchePourAsso(Long id);

    String supprimer(Long id);
}
