package ma.enset.gestiondesstages.repositories;

import ma.enset.gestiondesstages.models.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FiliereRepository extends JpaRepository<Filiere,String> {
    Filiere findByCodeFiliere(String codeFiliere);
}
