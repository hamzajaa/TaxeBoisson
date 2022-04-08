package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.TaxeBoisson;
import com.example.taxeboisson.service.facade.TaxeBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/taxeBoisson")
public class TaxeBoissonWs {

    @Autowired
    private TaxeBoissonService taxeBoissonService;

    @PostMapping("/")
    public int save(@RequestBody TaxeBoisson taxeBoisson) {
        return taxeBoissonService.save(taxeBoisson);
    }

    @GetMapping("/ref/{ref}")
    public TaxeBoisson findByRef(@PathVariable String ref) {
        return taxeBoissonService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return taxeBoissonService.deleteByRef(ref);
    }

    @GetMapping("/annee/{annee}")
    public TaxeBoisson findByAnnee(@PathVariable int annee) {
        return taxeBoissonService.findByAnnee(annee);
    }

    @DeleteMapping("/annee/{annee}")
    public int deleteByAnnee(@PathVariable int annee) {
        return taxeBoissonService.deleteByAnnee(annee);
    }

    @GetMapping("/local/ref/{ref}")
    public List<TaxeBoisson> findByLocalRef(@PathVariable String ref) {
        return taxeBoissonService.findByLocalRef(ref);
    }

    @DeleteMapping("/local/ref/{ref}")
    public int deleteByLocalRef(@PathVariable String ref) {
        return taxeBoissonService.deleteByLocalRef(ref);
    }
}
