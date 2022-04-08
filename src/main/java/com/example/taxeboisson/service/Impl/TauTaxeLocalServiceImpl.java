package com.example.taxeboisson.service.Impl;

import com.example.taxeboisson.bean.TauTaxeLocal;
import com.example.taxeboisson.dao.TauTaxeLocalDao;
import com.example.taxeboisson.service.facade.TauTaxeLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TauTaxeLocalServiceImpl implements TauTaxeLocalService {

    @Autowired
    private TauTaxeLocalDao tauTaxeLocalDao;

    public int save(TauTaxeLocal tauTaxeLocal){
        if (findByCode(tauTaxeLocal.getCode()) != null){
            return -1;
        }else if (tauTaxeLocal.getPourcentage() < 0){
            return -2;
        }else {
            tauTaxeLocalDao.save(tauTaxeLocal);
            return 1;
        }
    }

    @Override
    public TauTaxeLocal findByCode(String code) {
        return tauTaxeLocalDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return tauTaxeLocalDao.deleteByCode(code);
    }
}
