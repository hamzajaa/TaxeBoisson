package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.TaxeBoisson;

import java.util.List;

public interface TaxeBoissonService {

    int save(TaxeBoisson taxeBoisson);

    TaxeBoisson findByRef(String ref);
    int deleteByRef(String  ref);

    TaxeBoisson findByAnnee(int annee);
    int deleteByAnnee(int annee);

    List<TaxeBoisson> findByLocalRef(String ref);
    int deleteByLocalRef(String ref);
}
