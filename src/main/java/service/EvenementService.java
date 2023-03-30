package service;

import jdk.jfr.DataAmount;
import model.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EvenementRepository;


public interface EvenementService {


    Iterable<Evenement> getEvenements();

}
