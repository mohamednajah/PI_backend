package ma.enset.gestiondesstages.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant
{
    @Id
    private String codeApogee;
    private String cne;
    private String cni;
    private String nom;
    private String prenom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @OneToOne @JsonIgnore
    private Filiere filiere;


    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    private String ville;

    private String adresse;
    private String telephone;
    private String email;
    public String userId;
    @OneToMany(mappedBy = "etudiant", fetch = FetchType.LAZY) @JsonIgnore
    private List<Stage> stages;
    public void setCodeApogee(String codeApogee) {
        this.codeApogee = codeApogee;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public String getCodeApogee() {
        return codeApogee;
    }

    public String getCne() {
        return cne;
    }

    public String getCni() {
        return cni;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }

    public List<Stage> getStages() {
        return stages;
    }




}
