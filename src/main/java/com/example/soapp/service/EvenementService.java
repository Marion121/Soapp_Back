package com.example.soapp.service;

import com.example.soapp.model.Evenement;

import java.util.List;


public interface EvenementService {

    List<Evenement> getEvenements();

    Evenement creerEvenement(Evenement evenement);

}
