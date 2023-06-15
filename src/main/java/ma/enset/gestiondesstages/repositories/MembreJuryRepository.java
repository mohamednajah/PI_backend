package ma.enset.gestiondesstages.repositories;

import ma.enset.gestiondesstages.models.MembreJury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembreJuryRepository extends JpaRepository<MembreJury,String> {
}
