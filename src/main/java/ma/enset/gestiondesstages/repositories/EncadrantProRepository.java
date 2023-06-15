package ma.enset.gestiondesstages.repositories;

import ma.enset.gestiondesstages.models.EncadrantProfessionnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncadrantProRepository extends JpaRepository<EncadrantProfessionnel, String> {

}
