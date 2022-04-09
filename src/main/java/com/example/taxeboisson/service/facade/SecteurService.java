package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.Secteur;

public interface SecteurService {

    int save(Secteur secteur);

    Secteur findByCode(String code);
    int deleteByCode(String code);

    Secteur findByLibelle(String libelle);
    int deleteByLibelle(String libelle);
}
