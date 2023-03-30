package repository;

import model.Bureau;
import model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BureauRepository extends JpaRepository<Bureau, Long> {

}
