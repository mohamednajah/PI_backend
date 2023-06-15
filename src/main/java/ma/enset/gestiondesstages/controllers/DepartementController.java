package ma.enset.gestiondesstages.controllers;
import ma.enset.gestiondesstages.models.Departement;
import ma.enset.gestiondesstages.repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartementController {

    @Autowired
    private DepartementRepository departementRepository;

    @GetMapping("/departements")
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @GetMapping("/departement/{codeDepartement}")
    public Departement getDepartementByCode(@PathVariable String codeDepartement) {
        return departementRepository.findByCodeDepartement(codeDepartement);
    }

    @PostMapping("/departement")
    public Departement createDepartement(@RequestBody Departement departement) {
        return departementRepository.save(departement);
    }

    @PutMapping("/departement/{codeDepartement}")
    public Departement updateDepartement(@PathVariable String codeDepartement, @RequestBody Departement departement) {
        Departement departement1= departementRepository.findByCodeDepartement(codeDepartement);
        if (departement.getIntitule()!=null) departement1.setIntitule(departement.getIntitule());
        if (departement.getChefDepartement()!=null) departement1.setChefDepartement(departement.getChefDepartement());
        if (departement.getEncadrantAcademique()!=null) departement1.setEncadrantAcademique(departement.getEncadrantAcademique());
        if (departement.getFilieres()!=null) departement1.setFilieres(departement.getFilieres());
        return departementRepository.save(departement1);
    }
    @DeleteMapping("/departement/{codeDepartement}")
    public void deleteDepartement(@PathVariable String codeDepartement) {
        departementRepository.deleteById(codeDepartement);
    }
}
