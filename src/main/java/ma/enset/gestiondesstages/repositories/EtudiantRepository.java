package ma.enset.gestiondesstages.repositories;

import ma.enset.gestiondesstages.models.Etudiant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, String>
{
    List<Etudiant> findByVille(String city);
    @Query("select c from Etudiant c where c.nom like :kw or c.prenom like :kw or c.codeApogee like :kw or c.ville like :kw" )
    List<Etudiant> searchEtudiants(@Param("kw") String keyword);

}

