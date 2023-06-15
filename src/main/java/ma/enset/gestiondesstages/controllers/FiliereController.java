package ma.enset.gestiondesstages.controllers;


import ma.enset.gestiondesstages.models.Entreprise;
import ma.enset.gestiondesstages.models.Filiere;
import ma.enset.gestiondesstages.repositories.EntrepriseRepository;
import ma.enset.gestiondesstages.repositories.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FiliereController {
    @Autowired
    private FiliereRepository filiereRepository;

    @GetMapping("/filieres")
    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }
    @GetMapping("/filieres/{codeFiliere}")
    public Filiere getFiliereByCode(@PathVariable String codeFiliere) {
        return filiereRepository.findByCodeFiliere(codeFiliere);
    }


    @PostMapping("/filiere")
    public Filiere createFiliere(@RequestBody Filiere filiere) {
         return filiereRepository.save(filiere);
    }

    @PutMapping("/filiere/{codeFiliere}")
    public Filiere updateFiliere(@PathVariable String codeFiliere, @RequestBody Filiere filiere) {
        Filiere filiere1= filiereRepository.findByCodeFiliere(codeFiliere);
        if(filiere.getIntituleFiliere()!=null) filiere1.setIntituleFiliere(filiere.getIntituleFiliere());
        if(filiere.getDescriptionFiliere()!=null) filiere1.setDescriptionFiliere(filiere.getDescriptionFiliere());
        if(filiere.getChefFiliere()!=null) filiere1.setChefFiliere(filiere.getChefFiliere());
        if(filiere.getEtudiants()!=null) filiere1.setEtudiants(filiere.getEtudiants());
        return filiereRepository.save(filiere1);
    }

    @DeleteMapping("/filiere/{codeFiliere}")
    public void deleteFiliere(@PathVariable String codeFiliere) {
        filiereRepository.deleteById(codeFiliere);
    }


}
