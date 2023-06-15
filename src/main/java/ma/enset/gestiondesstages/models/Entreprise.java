package ma.enset.gestiondesstages.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entreprise {
    @Id
    private String nomEntreprise;
    private String type;
    private String activite;
    private Boolean partenaire;
    @OneToMany
    @ToString.Exclude
    private List<Stage> stages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Entreprise that = (Entreprise) o;
        return nomEntreprise != null && Objects.equals(nomEntreprise, that.nomEntreprise);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
