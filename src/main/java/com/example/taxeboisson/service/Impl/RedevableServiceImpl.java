package com.example.taxeboisson.service.Impl;

import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.TypeRedevable;
import com.example.taxeboisson.dao.RedevableDao;
import com.example.taxeboisson.service.facade.LocalService;
import com.example.taxeboisson.service.facade.RedevableService;
import com.example.taxeboisson.service.facade.TaxeBoissonService;
import com.example.taxeboisson.service.facade.TypeRedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RedevableServiceImpl implements RedevableService {

    @Autowired
    private RedevableDao redevableDao;
    @Autowired
    private TypeRedevableService typeRedevableService;
    @Autowired
    private LocalService localService;
    @Autowired
    private TaxeBoissonService taxeBoissonService;

    @Override
    public int save(Redevable redevable) {

        TypeRedevable typeRedevable = typeRedevableService.findByCode(redevable.getTypeRedevable().getCode());
        redevable.setTypeRedevable(typeRedevable);

        if (findByCin(redevable.getCin()) != null) {
            return -1;
        } else if (typeRedevable == null || typeRedevable.getCode().isEmpty()) {
            return -2;
        } else {
            redevableDao.save(redevable);
            return 1;
        }
    }

    @Override
    public Redevable findByCin(String cin) {
        return redevableDao.findByCin(cin);
    }

    @Override
    @Transactional
    public int deleteByCin(String cin) {
        return redevableDao.deleteByCin(cin);
    }

    @Override
    public List<Redevable> findByTypeRedevableCode(String code) {
        return redevableDao.findByTypeRedevableCode(code);
    }

    @Override
    @Transactional
    public int deleteByTypeRedevableCode(String code) {
        return redevableDao.deleteByTypeRedevableCode(code);
    }

    @Override
    @Transactional
    public int deleteRedevableWithLocalAndTa(String cin){
        int res1 = taxeBoissonService.deleteByRedevableCin(cin);
        int res2 = localService.deleteByRedevableCin(cin);
        int res3 = redevableDao.deleteByCin(cin);
        return res1+res2+res3;
    }
}
