package com.example.soapp.repository;

import com.example.soapp.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {


}
