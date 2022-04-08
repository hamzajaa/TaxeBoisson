package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.Local;
import com.example.taxeboisson.service.facade.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/local")
public class LocalWs {

    @Autowired
    private LocalService localService;

    @PostMapping("/")
    public int save(@RequestBody Local local) {
        return localService.save(local);
    }

    @GetMapping("/ref/{ref}")
    public Local findByRef(@PathVariable String ref) {
        return localService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return localService.deleteByRef(ref);
    }

    @GetMapping("/categorie/code/{code}")
    public List<Local> findByCategorieLocalCode(@PathVariable String code) {
        return localService.findByCategorieLocalCode(code);
    }

    @DeleteMapping("/categorie/code/{code}")
    public int deleteByCategorieLocalCode(@PathVariable String code) {
        return localService.deleteByCategorieLocalCode(code);
    }

    @GetMapping("/redevable/cin/{cin}")
    public List<Local> findByRedevableCin(@PathVariable String cin) {
        return localService.findByRedevableCin(cin);
    }

    @DeleteMapping("/redevable/cin/{cin}")
    public int deleteByRedevableCin(@PathVariable String cin) {
        return localService.deleteByRedevableCin(cin);
    }

    @GetMapping("/secteur/code/{code}")
    public List<Local> findBySecteurCode(@PathVariable String code) {
        return localService.findBySecteurCode(code);
    }
    @DeleteMapping("/secteur/code/{code}")
    public int deleteBySecteurCode(@PathVariable String code) {
        return localService.deleteBySecteurCode(code);
    }
}
