package com.example.soapp.service;

import com.example.soapp.model.Association;

import java.util.List;

public interface AssociationService {

    List<Association> getAssociation();

    Association creerAssociation(Association association);

    Association rechercher(Long id); // par id

    Association modifier(Association association, Long id);

}
