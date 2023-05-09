package com.example.soapp.service;

import com.example.soapp.model.Evenement;

import java.util.List;
import java.util.Optional;


public interface EvenementService {

    List<Evenement> getEvenements();

    Evenement creerEvenement(Evenement evenement);

    Optional<Evenement> rechercheParId(Long id);

    List<Evenement> rechercheParJour(int jour);

    List<Evenement> rechercheCalendrier(int mois);

    Evenement modifier(Evenement evenement, Long id);

    List<Evenement> rechercheFeed();

    List<Evenement> recherchePourAsso(String nom);

    String supprimer(Long id);
}
