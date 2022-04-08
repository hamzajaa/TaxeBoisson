package com.example.taxeboisson.service.facade;


import com.example.taxeboisson.bean.TauTaxeLocal;

public interface TauTaxeLocalService {
    TauTaxeLocal findByCode(String code);
    int deleteByCode(String code);

}
