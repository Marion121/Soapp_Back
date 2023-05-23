package com.example.soapp.service;

import com.example.soapp.model.Etudiant;
import com.example.soapp.model.Evenement;
import com.example.soapp.repository.EvenementRepository;
import com.example.soapp.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class EvenementServicelmpl implements EvenementService{
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private EtudiantService etudiantService;
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
    public List<Evenement> recherchePourAsso(Long id){
        return evenementRepository.recherchePourAsso(id);
    }

    @Override
    public String like(Long EvenementId, Long idEtudiant) {
        Evenement event = rechercheParId(EvenementId).orElse(null);
        Etudiant etudiant = etudiantService.rechercheParId(idEtudiant).orElse(null);
        if (event == null || etudiant == null) {
            return "id event ou etudiant faux";
        }
        event.getEtudiants().add(etudiant);
        etudiant.getEvenementParticipe().add(event);
        evenementRepository.save(event);
        etudiantRepository.save(etudiant);
        return event.toString();
    }

    @Override
    public String dislike(Long EvenementId, Long idEtudiant) {
        Evenement event = rechercheParId(EvenementId).orElse(null);
        Etudiant etudiant = etudiantService.rechercheParId(idEtudiant).orElse(null);
        if (event == null || etudiant == null) {
            return "erreur un des 2 id est faux";
        }
        event.getEtudiants().remove(etudiant);
        etudiant.getEvenementParticipe().remove(event);
        evenementRepository.save(event);
        etudiantRepository.save(etudiant);
        return event.toString();
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
                    if(evenement.getDate_debut_evenement() != null){
                        event.setDate_debut_evenement(evenement.getDate_debut_evenement());
                    }
                    if(evenement.getDate_fin_evenement() != null){
                        event.setDate_fin_evenement(evenement.getDate_fin_evenement());
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
                    if(evenement.getAssociation_id() != null){
                        event.setAssociation_id(evenement.getAssociation_id());
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
