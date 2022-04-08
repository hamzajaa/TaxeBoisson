package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.TauTaxeLocal;
import com.example.taxeboisson.service.facade.TauTaxeLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tau-tax-local")
public class TauTaxLocalWs {

    @Autowired
    private TauTaxeLocalService tauTaxeLocalService;

    @PutMapping("/ref/{ref}/nvPer/{nvPer}")
    public int updatePer(@PathVariable String ref,@PathVariable double nvPer) {
        return tauTaxeLocalService.updatePer(ref, nvPer);
    }

    @GetMapping("/categorie/code/{code}")
    public TauTaxeLocal findByCategorieLocalCode(@PathVariable String code) {
        return tauTaxeLocalService.findByCategorieLocalCode(code);
    }

    @DeleteMapping("/categorie/code/{code}")
    public int deleteByCategorieLocalCode(@PathVariable String code) {
        return tauTaxeLocalService.deleteByCategorieLocalCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody TauTaxeLocal tauTaxeLocal) {
        return tauTaxeLocalService.save(tauTaxeLocal);
    }

    @GetMapping("/code/{code}")
    public TauTaxeLocal findByCode(@PathVariable String code) {
        return tauTaxeLocalService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return tauTaxeLocalService.deleteByCode(code);
    }
}
