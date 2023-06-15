package ma.enset.gestiondesstages.controllers;

import ma.enset.gestiondesstages.models.EncadrantAcademique;
import ma.enset.gestiondesstages.repositories.EncadrantAcademiqueRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EncadrantAcademiqueController {
        EncadrantAcademiqueRepository encadrantAcademiqueRepository;

        public EncadrantAcademiqueController(EncadrantAcademiqueRepository encadrantAcademiqueRepository) {
            this.encadrantAcademiqueRepository = encadrantAcademiqueRepository;
        }

        @GetMapping("/encadrantsAcademique")
        public List<EncadrantAcademique> getencadrants(){
            return encadrantAcademiqueRepository.findAll();
        }
        @PostMapping("/encadrantsAcademiques/ajouter")
        public EncadrantAcademique addEncadrantAcademique(@RequestBody EncadrantAcademique encadrantAcademique){
            return encadrantAcademiqueRepository.save(encadrantAcademique);
        }

        @PutMapping("/encadrantsAcademiques/modifier/{id}")
        public EncadrantAcademique update(@PathVariable String id, @RequestBody EncadrantAcademique encadrantAcademique)
        {
            EncadrantAcademique encadrantAcademique1 = encadrantAcademiqueRepository.findById(id).orElseThrow();
            if(encadrantAcademique.getNom()!=null)encadrantAcademique1.setNom(encadrantAcademique.getNom());
            if(encadrantAcademique.getPrenom()!=null)encadrantAcademique1.setPrenom(encadrantAcademique.getPrenom());
            if(encadrantAcademique.getDepartement()!=null)encadrantAcademique1.setDepartement(encadrantAcademique.getDepartement());
            if(encadrantAcademique.getStages()!=null)encadrantAcademique1.setStages(encadrantAcademique.getStages());
            return encadrantAcademiqueRepository.save(encadrantAcademique1);
        }

        @DeleteMapping("/encadrantsAcademiques/supprimer/{id}")
        public void delete(@PathVariable String id){
            encadrantAcademiqueRepository.deleteById(id);
        }
}

