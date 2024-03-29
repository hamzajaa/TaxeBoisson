package com.example.taxeboisson.service.Impl;

import com.example.taxeboisson.bean.CategorieLocal;
import com.example.taxeboisson.bean.TauTaxeLocal;
import com.example.taxeboisson.dao.TauTaxeLocalDao;
import com.example.taxeboisson.service.facade.CategorieLocalService;
import com.example.taxeboisson.service.facade.TauTaxeLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TauTaxeLocalServiceImpl implements TauTaxeLocalService {

    @Autowired
    private TauTaxeLocalDao tauTaxeLocalDao;
    @Autowired
    private CategorieLocalService categorieLocalService;

    @Override
    public int save(TauTaxeLocal tauTaxeLocal) {
        CategorieLocal categorieLocal = categorieLocalService.findByCode(tauTaxeLocal.getCategorieLocal().getCode());
        tauTaxeLocal.setCategorieLocal(categorieLocal);
        if (findByCode(tauTaxeLocal.getCode()) != null) {
            return -1;
        } else if (tauTaxeLocal.getPourcentage() <= 0) {
            return -2;
        } else if (categorieLocal == null || categorieLocal.getCode().isEmpty()) {
            return -3;
        } else {
            tauTaxeLocalDao.save(tauTaxeLocal);
            return 1;
        }
    }

    @Override
    public int updatePer(String ref, double nvPer) {
        TauTaxeLocal tauTaxeLocal = findByCode(ref);
        if (tauTaxeLocal == null) {
            return -1;
        } else if (nvPer <= 0) {
            return -2;
        } else {
            tauTaxeLocal.setPourcentage(nvPer);
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

    @Override
    public TauTaxeLocal findByCategorieLocalCode(String code) {
        return tauTaxeLocalDao.findByCategorieLocalCode(code);
    }

    @Override
    @Transactional
    public int deleteByCategorieLocalCode(String code) {
        return tauTaxeLocalDao.deleteByCategorieLocalCode(code);
    }
}
