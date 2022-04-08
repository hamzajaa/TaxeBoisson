package com.example.taxeboisson.service.facade;


import com.example.taxeboisson.bean.TauTaxeLocal;

public interface TauTaxeLocalService {
    int save(TauTaxeLocal tauTaxeLocal);

    TauTaxeLocal findByCode(String code);
    int deleteByCode(String code);

}
