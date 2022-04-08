package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.CategorieLocal;
import com.example.taxeboisson.service.facade.CategorieLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categorie-local")
public class CategorieLocalWS {

    @Autowired
    private CategorieLocalService categorieLocalService;

    @PostMapping("/")
    public int save(@RequestBody CategorieLocal categorieLocal) {
        return categorieLocalService.save(categorieLocal);
    }

    @GetMapping("/ref/{ref}")
    public CategorieLocal findByCode(String ref) {
        return categorieLocalService.findByCode(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByCode(String ref) {
        return categorieLocalService.deleteByCode(ref);
    }
}
