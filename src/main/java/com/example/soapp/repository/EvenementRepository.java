package com.example.soapp.repository;

import com.example.soapp.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

    @Query(value = "SELECT evenement.id, evenement.date_creation, evenement.date_evenement, evenement.date_heure_shotgun, evenement.description, evenement.lien, evenement.lieu, evenement.nbr_place, evenement.nom, evenement.prix_cotisant, evenement.prix_non_cotisant, evenement.titre_lien, evenement.validation" +
                   " FROM evenement WHERE DAY(date_evenement) = :jour ORDER BY date_evenement" , nativeQuery = true)
    public abstract List<Evenement> rechercheParJour(int jour);

    @Query(value = "SELECT evenement.id, evenement.date_creation, evenement.date_evenement, evenement.date_heure_shotgun, evenement.description, evenement.lien, evenement.lieu, evenement.nbr_place, evenement.nom, evenement.prix_cotisant, evenement.prix_non_cotisant, evenement.titre_lien, evenement.validation" +
            " FROM evenement WHERE MONTH(date_evenement) = :mois GROUP BY DAY(date_evenement)", nativeQuery = true)
    public abstract List<Evenement> rechercheCalendrier(int mois);

    @Query(value = "SELECT evenement.id, evenement.date_creation, evenement.date_evenement, evenement.date_heure_shotgun, evenement.description, evenement.lien, evenement.lieu, evenement.nbr_place, evenement.nom, evenement.prix_cotisant, evenement.prix_non_cotisant, evenement.titre_lien, evenement.validation" +
            " FROM evenement" +
            " WHERE evenement.validation = TRUE AND DAY(NOW()) <= DAY(evenement.date_evenement)", nativeQuery = true)
    public abstract List<Evenement> rechercheFeed();


    @Query(value = "SELECT evenement.id, evenement.date_creation, evenement.date_evenement, evenement.date_heure_shotgun, evenement.description, evenement.lien, evenement.lieu, evenement.nbr_place, evenement.nom, evenement.prix_cotisant, evenement.prix_non_cotisant, evenement.titre_lien, evenement.validation" +
            " FROM evenement INNER JOIN event_asso on evenement.id = event_asso.evenement_id " +
            "INNER JOIN association a on event_asso.association_id = a.id " +
            "WHERE a.nom = :nom", nativeQuery = true)
    public abstract List<Evenement> recherchePourAsso(String nom);
}
