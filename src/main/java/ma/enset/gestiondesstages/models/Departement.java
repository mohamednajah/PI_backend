package ma.enset.gestiondesstages.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Departement {
    @Id
    private String codeDepartement;
    private String intitule;
    private String chefDepartement;
    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    private List<EncadrantAcademique> encadrantAcademique;

    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    private List<Filiere> filieres;

}
