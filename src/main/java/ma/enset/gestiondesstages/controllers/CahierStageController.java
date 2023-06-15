package ma.enset.gestiondesstages.controllers;


import ma.enset.gestiondesstages.models.CahierStage;
import ma.enset.gestiondesstages.repositories.CahierStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CahierStageController {
    @Autowired
    private CahierStageRepository cahierStageRepository;
    @GetMapping("/cahierStages")
    public List<CahierStage> getAllCahierStages() {
        return cahierStageRepository.findAll();
    }

    @GetMapping("/cahierStages/{idCahierStage}")
    public CahierStage getCahierStageById(@PathVariable String idCahierStage) {
        return cahierStageRepository.findById(idCahierStage).get();
    }

    @PostMapping("/cahierStage")
    public CahierStage createCahierStage(CahierStage cahierStage) {
        return cahierStageRepository.save(cahierStage);
    }

    @PutMapping("/cahierStage/{idCahierStage}")
    public CahierStage updateCahierStage(@PathVariable String idCahierStage, @RequestBody CahierStage cahierStage) {
        CahierStage cahierStage1= cahierStageRepository.findById(idCahierStage).get();
        if (cahierStage.getStage()!=null) cahierStage1.setStage(cahierStage.getStage());
        if (cahierStage.getDocuments()!=null) cahierStage1.setDocuments(cahierStage.getDocuments());
        return cahierStageRepository.save(cahierStage1);
    }

    @DeleteMapping("/cahierStage/{idCahierStage}")
    public void deleteCahierStage(@PathVariable String idCahierStage) {
        cahierStageRepository.deleteById(idCahierStage);
    }
}
