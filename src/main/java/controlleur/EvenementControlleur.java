package controlleur;

import model.Evenement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.EvenementService;
@RestController
public class EvenementControlleur {
    private EvenementService evenementService;


    @GetMapping("/evenements")
    public Iterable<Evenement> getEvenements() {
        return evenementService.getEvenements();
    }
}
