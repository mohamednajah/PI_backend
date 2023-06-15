package ma.enset.gestiondesstages.repositories;

import ma.enset.gestiondesstages.models.CahierStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CahierStageRepository extends JpaRepository<CahierStage,String> {
}
