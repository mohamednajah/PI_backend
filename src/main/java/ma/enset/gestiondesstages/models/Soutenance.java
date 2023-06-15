package ma.enset.gestiondesstages.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Soutenance {
    @Id
    private int idSoutenance;
    private Date dateSoutenance;
    private float note;
    private String salle;
    @OneToOne
    private Stage stage;
    @ManyToMany(mappedBy = "soutenances", fetch = FetchType.LAZY)
    private List<MembreJury> jury;
}
