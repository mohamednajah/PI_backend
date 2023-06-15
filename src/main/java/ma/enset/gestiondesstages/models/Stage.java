package ma.enset.gestiondesstages.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.gestiondesstages.enums.TypeStage;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stage
{
    @Id
    private Long idStage;
    private String intituleStage;
    private String descriptionStage;
    private TypeStage typeStage;
    private String ville;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Boolean embauche;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private EncadrantAcademique encadrantAcademique;
    @ManyToOne
    private EncadrantProfessionnel encadrantProfessionnel;
    @ManyToOne
    private Entreprise entreprise;
}
