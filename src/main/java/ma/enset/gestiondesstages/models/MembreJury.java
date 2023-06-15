package ma.enset.gestiondesstages.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembreJury {
    @Id
    private int idJury;
    private String nom;
    private String prenom;
    @ManyToMany
    private List<Soutenance> soutenances;
}
