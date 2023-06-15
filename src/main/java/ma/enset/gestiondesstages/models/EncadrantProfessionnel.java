package ma.enset.gestiondesstages.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@DiscriminatorValue("Professionnel")
public class EncadrantProfessionnel extends Encadrant{
    private String service;
    private String poste;
    @OneToMany(mappedBy = "encadrantProfessionnel", fetch = FetchType.LAZY)
    private List<Stage> stages;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }
}
