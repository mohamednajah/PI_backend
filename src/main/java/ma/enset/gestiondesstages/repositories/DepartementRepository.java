package ma.enset.gestiondesstages.repositories;

import ma.enset.gestiondesstages.models.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,String> {
    Departement findByCodeDepartement(String codeDepartement);
}
