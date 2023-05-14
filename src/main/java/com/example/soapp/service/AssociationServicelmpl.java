package com.example.soapp.service;

import com.example.soapp.model.Association;
import com.example.soapp.repository.AssociationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@RestController
@Service
@AllArgsConstructor
public class AssociationServicelmpl implements AssociationService{

    @Autowired
    AssociationRepository associationRepository;

    public List<Association> getAllAssociation(){
        return associationRepository.findAll();
    }

    @Override
    public Association creerAssociation(Association association) {
        Date date = new Date();
        TimeZone.setDefault( TimeZone.getTimeZone("GMT"));

        return associationRepository.save(association);
    }

    @Override
    public Optional<Association> rechercheParId(Long id) {
        return associationRepository.findById(id);
    }

    @Override
    public Association modifier(Association association, Long id) {
        return associationRepository.findById(id)
                .map(asso -> {
                    if(association.getNom() != null){
                        asso.setNom(association.getNom());
                    }
                    if(association.getMdp() != null){
                        asso.setMdp(association.getMdp());
                    }
                    if(association.getMail() != null){
                        asso.setMail(association.getMail());
                    }
                    if(association.getCouleur() != null){
                        asso.setCouleur(association.getCouleur());
                    }
                    if(association.getDescription() != null){
                        asso.setDescription(association.getDescription());
                    }
                    if(association.getLogo() != null){
                        asso.setLogo(association.getLogo());
                    }
                    return associationRepository.save(asso);
                })
                .orElseThrow(() -> new RuntimeException("Association not found"));
    }

    @Override
    public String supprimer(Long id) {
        associationRepository.deleteById(id);
        return "Association supprimée";
    }
}
