package ma.enset.gestiondesstages.repositories;

import ma.enset.gestiondesstages.models.EncadrantAcademique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncadrantAcademiqueRepository extends JpaRepository<EncadrantAcademique, String> {
}
