package ma.enset.gestiondesstages.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CahierStage
{
    @Id
    private long idCahier;
    @ElementCollection
    private List<String> taches;
    private Date derniereModif;
    @OneToOne
    private Stage stage;
    @OneToMany(mappedBy = "cahierStage", fetch= FetchType.LAZY)
    private List<Document> documents;
}
