package ma.enset.gestiondesstages.repositories;

import ma.enset.gestiondesstages.models.Soutenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SoutenanceRepository extends JpaRepository<Soutenance,String> {
}
