package com.example.taxeboisson.service.facade;


import com.example.taxeboisson.bean.TauTaxeLocal;

public interface TauTaxeLocalService {
    int save(TauTaxeLocal tauTaxeLocal);


    int updatePer(String ref, double nvPer);

    TauTaxeLocal findByCode(String code);
    int deleteByCode(String code);

    TauTaxeLocal findByCategorieLocalCode(String code);
    int deleteByCategorieLocalCode(String code);

}
