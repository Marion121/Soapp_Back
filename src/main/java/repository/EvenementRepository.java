package repository;

import model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

    /*public Iterable<Evenement>  findall(){

    }*/

}
