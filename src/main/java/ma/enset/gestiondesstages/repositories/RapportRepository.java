package ma.enset.gestiondesstages.repositories;

import ma.enset.gestiondesstages.models.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportRepository extends JpaRepository<Rapport,String>{
}
