package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.Local;

import java.util.List;

public interface LocalService {



    int exec(Local local);

    Local findByRef(String ref);
    int deleteByRef(String ref);

    List<Local> findByCategorieLocalCode(String code);
    int deleteByCategorieLocalCode(String code);

    List<Local> findByRedevableCin(String cin);
    int deleteByRedevableCin(String cin);

    List<Local> findBySecteurCode(String code);
    int deleteBySecteurCode(String code);

    int deleteLocalWithTaxes(String ref);


    Local findByAdresse(String adresse);
    int deleteByAdresse(String adresse);

    Local findByRue(String rue);
    int deleteByRue(String rue);

}
