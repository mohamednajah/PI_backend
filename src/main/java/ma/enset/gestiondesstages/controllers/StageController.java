package ma.enset.gestiondesstages.controllers;

import ma.enset.gestiondesstages.models.Stage;

import ma.enset.gestiondesstages.repositories.StageRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@RestController
@CrossOrigin("*")
public class StageController {
    private StageRepository stageRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StageController(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    //Récupération
    @GetMapping("/stages")
    public List<Stage> Stages() {
        return stageRepository.findAll();
    }

    @GetMapping("/stages/{id}")
    public Stage Etudiants(@PathVariable Long id) {
        return stageRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Stage %s Introuvable!", id)));
    }

    //Ajout
    @PostMapping("/add/stages")
    public Stage save(@RequestBody Stage stage) {
        return stageRepository.save(stage);
    }

    //Modification
    @PutMapping("/stages/{id}")
    public Stage update(@PathVariable Long id, @RequestBody Stage stage) {
        Stage stage1 = stageRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Stage not found with ID: " + id));;
        if (stage.getDateDebut() != null) stage1.setDateDebut(stage.getDateDebut());
        if (stage.getDateFin() != null) stage1.setDateFin(stage.getDateFin());
        if (stage.getDescriptionStage() != null) stage1.setDescriptionStage(stage.getDescriptionStage());
        if (stage.getIntituleStage() != null) stage1.setIntituleStage(stage.getIntituleStage());
        if (stage.getVille() != null) stage1.setVille(stage.getVille());
        if (stage.getEntreprise() != null) stage1.setEntreprise(stage.getEntreprise());
        if (stage.getTypeStage() != null) stage1.setTypeStage(stage.getTypeStage());
      //  if (stage.getRapport() != null) stage1.setRapport(stage.getRapport());
        //if (stage.getCahierStage() != null) stage1.setCahierStage(stage.getCahierStage());
        if (stage.getEncadrantAcademique() != null) stage1.setEncadrantAcademique(stage.getEncadrantAcademique());
        if (stage.getEncadrantProfessionnel() != null) stage1.setEncadrantProfessionnel(stage.getEncadrantProfessionnel());
        //if (stage.getSoutenance() != null) stage1.setSoutenance(stage.getSoutenance());
        return stageRepository.save(stage1);
    }

    //SUPPRESSION
    @DeleteMapping("/stage/{id}")
    public void delete(@PathVariable Long id)
    {
        stageRepository.deleteById(id);
    }


//INDICATORS

    @GetMapping("/indicators")
    public Map<String, Object> getIndicators() {
        Map<String, Object> indicators = new HashMap<>();

        // Query 1: Get the count of records from the "stage" table
        String query1 = "SELECT COUNT(*) AS nb_offres FROM stage";
        List<Map<String, Object>> result1 = jdbcTemplate.queryForList(query1);
        indicators.put("Nombre_total", result1.get(0).get("nb_offres"));

        // Query 2: Get the count of stages per city
        String query2 = "SELECT ville, COUNT(*) AS nombre_stages FROM stage GROUP BY ville";
        List<Map<String, Object>> result2 = jdbcTemplate.queryForList(query2);
        indicators.put("Repartition_par_ville", result2);

        // Query 3: Get the count of partner companies
        String query3 ="SELECT DISTINCT entreprise.nom_entreprise AS Entreprise_Partenaire FROM stage " +
                "JOIN entreprise ON stage.entreprise_nom_entreprise = entreprise.nom_entreprise " +
                "WHERE entreprise.partenaire = true ";
        List<Map<String, Object>> result3 = jdbcTemplate.queryForList(query3);
        indicators.put("Entreprises_partenaires", result3);

        // Query 4: Get the conversion rate from stage to employment
        String query4 = "SELECT COUNT(*) / (SELECT COUNT(*) AS taux_de_conversion FROM stage WHERE etudiant_code_apogee IS NOT NULL) * 100 AS taux_conversion FROM stage WHERE embauche = true";
        List<Map<String, Object>> result4 = jdbcTemplate.queryForList(query4);
        indicators.put("Taux_conversion",
                result4.get(0).get("taux_conversion"));

        // Query 5: Get companies accepting the most stages
        String query5 = "SELECT entreprise.nom_entreprise AS ent, COUNT(*) AS nombre_stages FROM stage INNER JOIN entreprise ON stage.entreprise_nom_entreprise = entreprise.nom_entreprise WHERE etudiant_code_apogee IS NOT NULL GROUP BY entreprise.nom_entreprise ORDER BY COUNT(*) DESC LIMIT 5";
        List<Map<String, Object>> result5 = jdbcTemplate.queryForList(query5);
        indicators.put("Entreprises", result5);

        // Query 6: Get the most used technologies in stages
        String query6 = "SELECT DISTINCT stage.description_stage AS Sujets, COUNT(*)  AS Nombre FROM stage GROUP BY stage.description_stage ORDER BY Sujets DESC LIMIT 10";
        List<Map<String, Object>> result6 = jdbcTemplate.queryForList(query6);
        indicators.put("most_used_technologies", result6);

        return indicators;
    }




}
