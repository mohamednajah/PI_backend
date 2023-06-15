package ma.enset.gestiondesstages.controllers;

import ma.enset.gestiondesstages.models.Etudiant;
import ma.enset.gestiondesstages.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")

public class EtudiantRestController
{
    private EtudiantRepository EtudiantRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //Constructor dependency injection
    public EtudiantRestController(EtudiantRepository EtudiantRepository)
    {
        this.EtudiantRepository = EtudiantRepository;
    }
    @GetMapping("/Etudiants/search")
    public List<Etudiant> searchCustomers(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return EtudiantRepository.searchEtudiants("%"+keyword+"%");
    }
    //Récupération
    @GetMapping("/Etudiants")
    public List<Etudiant> Etudiants()
    {
        return EtudiantRepository.findAll();
    }

    @GetMapping("/Etudiants/{id}")
    public Etudiant Etudiants(@PathVariable String id)
    {
        return EtudiantRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Etudiant %s Introuvable!", id)));
    }
    @GetMapping("/Etudiants/villes/{ville}")
    public List<Etudiant> EtudiantsByVille(@PathVariable String ville)
    {
        return EtudiantRepository.findByVille(ville);
    }


    @GetMapping("/villes/etudiants")
    public List<Map<String, Object>> getVillesAvecPlusEtudiants() {
        String sql = "SELECT ville, COUNT(*) AS nb_etudiants FROM etudiant GROUP BY ville ORDER BY nb_etudiants DESC";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }

    //Ajout
    @PostMapping("/Etudiants")
    public Etudiant save(@RequestBody Etudiant Etudiant)
    {
        return EtudiantRepository.save(Etudiant);
    }
    //Modification
    @PutMapping("/Etudiants/{id}")
    public Etudiant update(@PathVariable String id, @RequestBody Etudiant etudiant)
    {
        Etudiant Etudiant1 = EtudiantRepository.findById(id).orElseThrow();
        if(etudiant.getCne()!=null)Etudiant1.setCne(etudiant.getCne());
        if(etudiant.getCni()!=null)Etudiant1.setCni(etudiant.getCni());
        if(etudiant.getNom()!=null)Etudiant1.setNom(etudiant.getNom());
        if(etudiant.getPrenom()!=null)Etudiant1.setPrenom(etudiant.getPrenom());
        if(etudiant.getDateNaissance()!=null)Etudiant1.setDateNaissance(etudiant.getDateNaissance());
        if(etudiant.getVille()!=null)Etudiant1.setVille(etudiant.getVille());
        if(etudiant.getAdresse()!=null)Etudiant1.setAdresse(etudiant.getAdresse());
        if(etudiant.getTelephone()!=null)Etudiant1.setTelephone(etudiant.getTelephone());
        if(etudiant.getEmail()!=null)Etudiant1.setEmail(etudiant.getEmail());
        if(etudiant.getUserId()!=null)Etudiant1.setUserId(etudiant.getUserId());
        return EtudiantRepository.save(Etudiant1);
    }

    //SUPPRESSION
    @DeleteMapping("/Etudiants/{id}")
    public void delete(@PathVariable String id)
    {
        EtudiantRepository.deleteById(id);
    }





}