package ma.enset.gestiondesstages.controllers;

import ma.enset.gestiondesstages.models.Entreprise;
import ma.enset.gestiondesstages.repositories.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

public class EntrepriseController {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @GetMapping("/entreprises")
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    @GetMapping("/{nomEntreprise}")
    public Entreprise getEntrepriseByNom(@PathVariable String nomEntreprise) {
        return entrepriseRepository.findEntrepriseByNomEntreprise(nomEntreprise);
    }
    @GetMapping("/entreprises/search")
    public List<Entreprise> search(@RequestParam(name = "keyword",defaultValue = "") String keyword){

        return  entrepriseRepository.findByNomEntrepriseContains(keyword);

    }

    @PostMapping("/entreprise")
    public Entreprise createEntreprise(@RequestBody Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @PutMapping("/{nomEntreprise}")
    public Entreprise updateEntreprise(@PathVariable String nomEntreprise, @RequestBody Entreprise entreprise) {
        Entreprise entreprise1= entrepriseRepository.findEntrepriseByNomEntreprise(nomEntreprise);
        if(entreprise.getType()!=null) entreprise1.setType(entreprise.getType());
        if(entreprise.getActivite()!=null) entreprise1.setActivite(entreprise.getActivite());
        if(entreprise.getStages()!=null) entreprise1.setStages(entreprise.getStages());
        return entrepriseRepository.save(entreprise1);
    }

    @DeleteMapping("/{nomEntreprise}")
    public void deleteEntreprise(@PathVariable String nomEntreprise) {
        entrepriseRepository.deleteById(nomEntreprise);
    }
}
