package com.example.soapp.service;

import com.example.soapp.model.Etudiant;
import com.example.soapp.model.Post;
import com.example.soapp.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class EtudiantServicempl implements EtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;
    public Etudiant creerEtudiant(Etudiant etudiant) {
        TimeZone.setDefault( TimeZone.getTimeZone("GMT"));
        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> getEtudiant(){
        return etudiantRepository.findAll();
    }

    @Override
    public Optional<Etudiant> rechercheParId(Long id){
        return etudiantRepository.findById(id);
    }

    @Override
    public String supprimer(Long id) {
        etudiantRepository.deleteById(id);
        return "etudiant supprimée";
    }
}
