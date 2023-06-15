package ma.enset.gestiondesstages.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rapport {
    @Id
    private int idRapport;
    private String intituleRapport;
    @OneToOne
    private Stage stage;
}
