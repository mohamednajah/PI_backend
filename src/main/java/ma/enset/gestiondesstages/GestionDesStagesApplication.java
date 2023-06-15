package ma.enset.gestiondesstages;


import ma.enset.gestiondesstages.models.*;
import ma.enset.gestiondesstages.repositories.EncadrantAcademiqueRepository;
import ma.enset.gestiondesstages.repositories.EncadrantProRepository;
import ma.enset.gestiondesstages.repositories.EtudiantRepository;
import ma.enset.gestiondesstages.repositories.FiliereRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;
import java.util.UUID;


@SpringBootApplication
public class GestionDesStagesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDesStagesApplication.class, args);
    }
    @Bean

    CommandLineRunner start(EtudiantRepository etudiantRepository, EncadrantProRepository encadrantProRepository, EncadrantAcademiqueRepository encadrantAcademiqueRepository, FiliereRepository filiereRepository) {
        return args -> {

            Etudiant etudiant = new Etudiant();
            etudiant.setCodeApogee("19827337");
            etudiant.setCne("H130230204");
            etudiant.setCni("F654546");
            etudiant.setNom("OUAKIL");
            etudiant.setPrenom("Manal");
            etudiant.setEmail("manalouakil16@gmail.com");
            etudiant.setDateNaissance(new Date());
            etudiant.setTelephone("0626155171");
            etudiant.setVille("OUJDA");
            etudiant.setAdresse("OUJDA N24");
            etudiantRepository.save(etudiant);
            System.out.println(etudiant);


            EncadrantProfessionnel encadrantProfessionnel = new EncadrantProfessionnel();
            encadrantProfessionnel.setId(UUID.randomUUID().toString());
            encadrantProfessionnel.setNom("HOUD");
            encadrantProfessionnel.setPrenom("Mohamed");
            encadrantProfessionnel.setPoste("Chef de service");
            encadrantProfessionnel.setService("Service informatique");
            encadrantProfessionnel.setUserId("mohamed.houd");
            encadrantProRepository.save(encadrantProfessionnel);
            System.out.println(encadrantProfessionnel);

            EncadrantAcademique encadrantAcademique = new EncadrantAcademique();
            encadrantAcademique.setId(UUID.randomUUID().toString());
            encadrantAcademique.setNom("Alami");
            encadrantAcademique.setPrenom("Aya");
            encadrantAcademiqueRepository.save(encadrantAcademique);


            Filiere filiere = new Filiere();
            filiere.setCodeFiliere(UUID.randomUUID().toString());
            filiere.setIntituleFiliere("Génie Logiciel");
            filiere.setChefFiliere("Mme. Aya Alami");
            filiereRepository.save(filiere);
            Filiere filiere2 = new Filiere();
            filiere.setCodeFiliere(UUID.randomUUID().toString());
            filiere.setIntituleFiliere("Big Data");
            filiere.setChefFiliere("Mme. Azedine khiat");
            filiereRepository.save(filiere);
        };
    }
}




