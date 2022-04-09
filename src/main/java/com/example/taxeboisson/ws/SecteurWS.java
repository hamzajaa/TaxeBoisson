package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.Secteur;
import com.example.taxeboisson.service.facade.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/secteur")
public class SecteurWS {

    @Autowired
    private SecteurService secteurService;

    @PostMapping("/")
    public int save(@RequestBody Secteur secteur) {
        return secteurService.save(secteur);
    }

    @GetMapping("/code/{code}")
    public Secteur findByCode(@PathVariable String code) {
        return secteurService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return secteurService.deleteByCode(code);
    }

    @GetMapping("/libelle/{libelle}")
    public Secteur findByLibelle(@PathVariable String libelle) {
        return secteurService.findByLibelle(libelle);
    }

    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return secteurService.deleteByLibelle(libelle);
    }
}
