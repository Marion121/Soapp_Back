package service;

import model.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EvenementRepository;
@Service
public class EvenementServicelmpl implements EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    public Iterable<Evenement> getEvenements(){
        return evenementRepository.findAll();
    }
}
