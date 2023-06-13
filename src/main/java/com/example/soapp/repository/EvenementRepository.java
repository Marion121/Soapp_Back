package com.example.soapp.repository;

import com.example.soapp.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

    @Query(value = "SELECT evenement.id, evenement.association_id, evenement.date_creation, evenement.date_fin_evenement, evenement.date_debut_evenement, evenement.poster, evenement.text, evenement.date_post, evenement.date_heure_shotgun, evenement.description, evenement.lien, evenement.lieu, evenement.nbr_place, evenement.nom,evenement.prix, evenement.titre_lien, evenement.validation" +
                   " FROM evenement WHERE DAY(date_debut_evenement) = :jour AND MONTH(date_debut_evenement) = :mois" , nativeQuery = true)
    public abstract List<Evenement> rechercheParJour(int jour, int mois);

    @Query(value = "SELECT evenement.id, evenement.association_id, evenement.date_creation, evenement.poster, evenement.text, evenement.date_post, evenement.date_fin_evenement, evenement.date_debut_evenement, evenement.date_heure_shotgun, evenement.description, evenement.lien, evenement.lieu, evenement.nbr_place, evenement.nom,evenement.prix, evenement.titre_lien, evenement.validation" +
            " FROM evenement WHERE MONTH(date_debut_evenement) = :mois ", nativeQuery = true)
    public abstract List<Evenement> rechercheCalendrier(int mois);

    @Query(value = "SELECT evenement.id, evenement.association_id, evenement.date_creation, evenement.poster, evenement.text, evenement.date_post, evenement.date_fin_evenement, evenement.date_debut_evenement, evenement.date_heure_shotgun, evenement.description, evenement.lien, evenement.lieu, evenement.nbr_place, evenement.nom,evenement.prix, evenement.titre_lien, evenement.validation" +
            " FROM evenement" +
            " WHERE evenement.validation = TRUE AND DAY(NOW()) <= DAY(evenement.date_evenement)", nativeQuery = true)
    public abstract List<Evenement> rechercheFeed();

    @Query(value = "SELECT evenement.id, evenement.association_id, evenement.date_creation,evenement.poster, evenement.date_post, evenement.date_fin_evenement, evenement.date_debut_evenement, evenement.date_heure_shotgun, evenement.description, evenement.lien, evenement.lieu, evenement.nbr_place, evenement.nom,evenement.prix, evenement.titre_lien,evenement.text, evenement.validation" +
            " FROM evenement " +
            "WHERE evenement.association_id= :id", nativeQuery = true)
    public abstract List<Evenement> recherchePourAsso(long id);

    // String sqlQuery  ="INSERT INTO `event_etudiant` (`etudiant_id`, `evenement_id`) VALUES ('3', '1');";
}
