package ma.enset.gestiondesstages.repositories;

import ma.enset.gestiondesstages.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document,String> {
}
