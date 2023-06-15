package ma.enset.gestiondesstages.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity

@Data
@Setter
@Getter
@DiscriminatorValue("Academique")
@AllArgsConstructor @NoArgsConstructor

public class EncadrantAcademique extends Encadrant{

    public EncadrantAcademique(String id, String nom, String prenom, String userId, List<Stage> stages, Departement departement) {
        super(id, nom, prenom, userId);
        this.stages = stages;
        this.departement = departement;
    }

    @OneToMany(mappedBy = "encadrantAcademique", fetch = FetchType.LAZY)
    private List<Stage> stages;
    @ManyToOne
    private Departement departement;
}
