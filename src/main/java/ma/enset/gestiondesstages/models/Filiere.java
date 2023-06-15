package ma.enset.gestiondesstages.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filiere
{
    @Id
    private String codeFiliere;
    private String intituleFiliere;
    private String descriptionFiliere;
    private String chefFiliere;
    @OneToMany
   private List<Etudiant> etudiants;
    @ManyToOne
    private Departement departement;
}
