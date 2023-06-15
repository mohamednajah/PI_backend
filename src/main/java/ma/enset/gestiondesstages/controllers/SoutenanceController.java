package ma.enset.gestiondesstages.controllers;

import ma.enset.gestiondesstages.models.Soutenance;
import ma.enset.gestiondesstages.repositories.SoutenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SoutenanceController {
    @Autowired
    SoutenanceRepository soutenanceRepository;

    @GetMapping("/soutenances")
    public List<Soutenance> getAllSoutenances() {
        return soutenanceRepository.findAll();
    }

    @GetMapping("/soutenance/{idSoutenance}")
    public Soutenance getSoutenanceById(String idSoutenance) {
        return soutenanceRepository.findById(idSoutenance).get();
    }

    @PostMapping("/soutenance")
    public Soutenance createSoutenance(Soutenance soutenance) {
        return soutenanceRepository.save(soutenance);
    }

    @PutMapping("/soutenance/{idSoutenance}")
    public Soutenance updateSoutenance(String idSoutenance, Soutenance soutenance) {
        Soutenance soutenance1= soutenanceRepository.findById(idSoutenance).get();
        if (soutenance.getDateSoutenance()!=null) soutenance1.setDateSoutenance(soutenance.getDateSoutenance());
        if (soutenance.getJury()!=null) soutenance1.setJury(soutenance.getJury());
        if (soutenance.getStage()!=null) soutenance1.setStage(soutenance.getStage());
        if (soutenance.getSalle()!=null) soutenance1.setSalle(soutenance.getSalle());
        //if (soutenance.getNote()!=null) soutenance1.setNote(soutenance.getNote());
        return soutenanceRepository.save(soutenance1);
    }
}
