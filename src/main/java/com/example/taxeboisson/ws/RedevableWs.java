package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.service.facade.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/redevable")
public class RedevableWs {

    @Autowired
    private RedevableService redevableService;

    @PostMapping("/")
    public int save(@RequestBody Redevable redevable) {
        return redevableService.save(redevable);
    }

    @GetMapping("/cin/{cin}")
    public Redevable findByCin(@PathVariable String cin) {
        return redevableService.findByCin(cin);
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return redevableService.deleteByCin(cin);
    }

    @GetMapping("/type-redevable/code/{code}")
    public List<Redevable> findByTypeRedevableCode(@PathVariable String code) {
        return redevableService.findByTypeRedevableCode(code);
    }

    @DeleteMapping("/type-redevable/code/{code}")
    public int deleteByTypeRedevableCode(@PathVariable String code) {
        return redevableService.deleteByTypeRedevableCode(code);
    }

    @DeleteMapping("/delete-r-l-t/cin/{cin}")
    public int deleteRedevableWithLocalAndTa(@PathVariable String cin) {
        return redevableService.deleteRedevableWithLocalAndTa(cin);
    }
}
