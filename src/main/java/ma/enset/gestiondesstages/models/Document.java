package ma.enset.gestiondesstages.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Id
    private int idDocument;
    private String titre;
    private String description;
    private Date dateDepot;
    @ManyToOne
    private CahierStage cahierStage;
}
