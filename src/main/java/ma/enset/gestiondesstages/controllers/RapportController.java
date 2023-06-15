package ma.enset.gestiondesstages.controllers;


import ma.enset.gestiondesstages.models.Rapport;
import ma.enset.gestiondesstages.repositories.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RapportController {
    @Autowired
    RapportRepository rapportRepository;

    @GetMapping("/rapports")
    public List<Rapport> getAllRapports() {
        return rapportRepository.findAll();
    }

    @GetMapping("/rapport/{idRapport}")
    public Rapport getRapportById(String idRapport) {
        return rapportRepository.findById(idRapport).get();
    }

    @PostMapping("/rapport")
    public Rapport createRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    @PutMapping("/rapport/{idRapport}")
    public Rapport updateRapport(String idRapport, Rapport rapport) {
        Rapport rapport1= rapportRepository.findById(idRapport).get();
        if (rapport.getStage()!=null) rapport1.setStage(rapport.getStage());
        if (rapport.getIntituleRapport()!=null) rapport1.setIntituleRapport(rapport.getIntituleRapport());
        return rapportRepository.save(rapport1);
    }

    @DeleteMapping("/rapport/{idRapport}")
    public void deleteRapport(String idRapport) {
        rapportRepository.deleteById(idRapport);
    }
}
