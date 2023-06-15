package ma.enset.gestiondesstages.repositories;

import ma.enset.gestiondesstages.models.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,String> {
       Entreprise findEntrepriseByNomEntreprise(String nomEntreprise);
       List<Entreprise> findByNomEntrepriseContains(String kw);
}
