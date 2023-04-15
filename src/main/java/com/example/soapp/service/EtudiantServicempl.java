package com.example.soapp.service;

import com.example.soapp.model.Etudiant;
import com.example.soapp.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TimeZone;

@Service
public class EtudiantServicempl implements EtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;
    public Etudiant creerEtudiant(Etudiant etudiant) {
        TimeZone.setDefault( TimeZone.getTimeZone("GMT"));
        return etudiantRepository.save(etudiant);
    }
}
