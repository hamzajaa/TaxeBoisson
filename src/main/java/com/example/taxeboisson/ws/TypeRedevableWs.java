package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.TypeRedevable;
import com.example.taxeboisson.service.facade.TypeRedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/type-redevable")
public class TypeRedevableWs {

    @Autowired
    private TypeRedevableService typeRedevableService;

    @PostMapping("/")
    public int save(@RequestBody TypeRedevable typeRedevable) {
        return typeRedevableService.save(typeRedevable);
    }

    @GetMapping("/code/{code}")
    public TypeRedevable findByCode(@PathVariable String code) {
        return typeRedevableService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return typeRedevableService.deleteByCode(code);
    }

    @DeleteMapping("/type-with-redevable/code/{code}")
    public int deleteTypewhithsRedevables(@PathVariable String code) {
        return typeRedevableService.deleteTypewhithsRedevables(code);
    }
}
