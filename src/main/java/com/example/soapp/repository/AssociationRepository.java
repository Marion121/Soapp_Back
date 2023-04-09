package com.example.soapp.repository;

import com.example.soapp.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {

/*
    @Query(value = "SELECT association.id, association.nom, association.couleur, association.mail, association.description, association.mdp, association.logo FROM association" , nativeQuery = true)
    public List<Association> findTout();*/
}