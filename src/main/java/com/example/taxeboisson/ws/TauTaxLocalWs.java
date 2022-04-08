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
