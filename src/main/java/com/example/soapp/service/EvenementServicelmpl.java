package com.example.soapp.service;

import com.example.soapp.model.Evenement;
import com.example.soapp.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class EvenementServicelmpl implements EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    public List<Evenement> getEvenements(){
        return evenementRepository.findAll();
    }

    @Override
    public Evenement creerEvenement(Evenement evenement) {
        Date date = new Date();
        TimeZone.setDefault( TimeZone.getTimeZone("GMT"));

        return evenementRepository.save(evenement);
    }
}
