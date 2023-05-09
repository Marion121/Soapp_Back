package com.example.soapp.service;

import com.example.soapp.model.Evenement;
import com.example.soapp.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class EvenementServicelmpl implements EvenementService{

    @Autowired
    private EvenementRepository evenementRepository;

    public List<Evenement> getEvenements(){
        return evenementRepository.findAll();
    }

    @Override
    public Evenement creerEvenement(Evenement evenement) {
        Date date = new Date();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        evenement.setDateCreation(date);
        return evenementRepository.save(evenement);
    }

    @Override
    public Optional<Evenement> rechercheParId(Long id){
        return evenementRepository.findById(id);
    }

    @Override
    public List<Evenement> rechercheParJour(int jour){
        return evenementRepository.rechercheParJour(jour);
    }

    @Override
    public List<Evenement> rechercheCalendrier(int mois){
        return evenementRepository.rechercheCalendrier(mois);
    }

    @Override
    public List<Evenement> recherchePourAsso(String nom){
        return evenementRepository.recherchePourAsso(nom);
    }



    @Override
    public List<Evenement> rechercheFeed(){
        return evenementRepository.rechercheFeed();
    }

    @Override
    public Evenement modifier(Evenement evenement, Long id) {
        return evenementRepository.findById(id)
                .map(event -> {
                    if(evenement.getNom() != null){
                        event.setNom(evenement.getNom());
                    }
                    if(evenement.getLieu() != null){
                        event.setLieu(evenement.getLieu());
                    }
                    if(evenement.getDate_evenement() != null){
                        event.setDate_evenement(evenement.getDate_evenement());
                    }
                    if(evenement.getValidation() != null){
                        event.setValidation(evenement.getValidation());
                    }
                    if(evenement.getDescription() != null){
                        event.setDescription(evenement.getDescription());
                    }
                    if(evenement.getNbr_place() != 0){
                        event.setNbr_place(evenement.getNbr_place());
                    }
                    if(evenement.getDate_heure_shotgun() != null){
                        event.setDate_heure_shotgun(evenement.getDate_heure_shotgun());
                    }
                    if(evenement.getAssociation() != null){
                        event.setAssociation(evenement.getAssociation());
                    }
                    if(evenement.getLien() != null){
                        event.setLien(evenement.getLien());
                    }
                    if(evenement.getTitre_lien() != null){
                        event.setTitre_lien(evenement.getTitre_lien());
                    }
                    if(evenement.getPrix_cotisant() != 0){
                        event.setPrix_cotisant(evenement.getPrix_cotisant());
                    }
                    return evenementRepository.save(event);
                })
                .orElseThrow(() -> new RuntimeException("Evenement not found"));
    }

    @Override
    public String supprimer(Long id) {
        evenementRepository.deleteById(id);
        return "Event supprimée";
    }

}
