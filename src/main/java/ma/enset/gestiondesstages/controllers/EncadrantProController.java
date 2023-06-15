package ma.enset.gestiondesstages.controllers;

import ma.enset.gestiondesstages.models.EncadrantProfessionnel;
import ma.enset.gestiondesstages.models.Entreprise;
import ma.enset.gestiondesstages.repositories.EncadrantProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EncadrantProController{


        @Autowired
        private EncadrantProRepository encadrantProRepository;

        @GetMapping("/encadrantsPro")
        public List<EncadrantProfessionnel> getAllEncadrantsPro() {
            return encadrantProRepository.findAll();
        }


        @PostMapping("/encadrantPro")
        public EncadrantProfessionnel createEncadrantPro(@RequestBody EncadrantProfessionnel encadrantPro) {
            return encadrantProRepository.save(encadrantPro);
        }

        @PutMapping("/{encadrantPro}")
        public EncadrantProfessionnel updateEncadrantPro(@PathVariable String encadrantProId, @RequestBody EncadrantProfessionnel encadrantPro) {
            EncadrantProfessionnel encadrantPro1= encadrantProRepository.findById(encadrantProId).get();
            if(encadrantPro.getNom()!=null) encadrantPro1.setNom(encadrantPro.getNom());
            if(encadrantPro.getPrenom()!=null) encadrantPro1.setPrenom(encadrantPro.getPrenom());
            if(encadrantPro.getPoste()!=null) encadrantPro1.setPoste(encadrantPro.getPoste());
            if(encadrantPro.getService()!=null) encadrantPro1.setService(encadrantPro.getService());
            if(encadrantPro.getStages()!=null) encadrantPro1.setStages(encadrantPro.getStages());
            if(encadrantPro.getUserId()!=null) encadrantPro1.setUserId(encadrantPro.getUserId());
            return encadrantProRepository.save(encadrantPro1);
        }

        @DeleteMapping("/{encadrantProId}")
        public void deleteEncadrantPro(@PathVariable String encadrantProId) {
            encadrantProRepository.deleteById(encadrantProId);
        }



}
