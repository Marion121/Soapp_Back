package com.example.soapp.service;

import com.example.soapp.model.Association;

import java.util.List;

public interface AssociationService {

    List<Association> getAllAssociation();

    Association creerAssociation(Association association);

    Association research(Long id); // par id

    Association modifier(Association association, Long id);

    String supprimer(Long id);

}
