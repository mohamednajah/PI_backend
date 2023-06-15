package ma.enset.gestiondesstages.controllers;

import ma.enset.gestiondesstages.models.MembreJury;
import ma.enset.gestiondesstages.repositories.MembreJuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MembreJuryController {
    @Autowired
    MembreJuryRepository membreJuryRepository;

    @GetMapping("/membreJurys")
    public List<MembreJury> getAllMembreJurys() {
        return membreJuryRepository.findAll();
    }

    @GetMapping("/membreJurys/{idMembreJury}")
    public MembreJury getMembreJuryById(String idMembreJury) {
        return membreJuryRepository.findById(idMembreJury).get();
    }

    @PostMapping("/membreJury")
    public MembreJury createMembreJury(MembreJury membreJury) {
        return membreJuryRepository.save(membreJury);
    }

    @PutMapping("/membreJury/{idMembreJury}")
    public MembreJury updateMembreJury(String idMembreJury, MembreJury membreJury) {
        MembreJury membreJury1= membreJuryRepository.findById(idMembreJury).get();
        if (membreJury.getNom()!=null) membreJury1.setNom(membreJury.getNom());
        if (membreJury.getPrenom()!=null) membreJury1.setPrenom(membreJury.getPrenom());
        if (membreJury.getSoutenances()!=null) membreJury1.setSoutenances(membreJury.getSoutenances());
        return membreJuryRepository.save(membreJury1);
    }

    @DeleteMapping("/membreJury/{idMembreJury}")
    public void deleteMembreJury(String idMembreJury) {
        membreJuryRepository.deleteById(idMembreJury);
    }
}
