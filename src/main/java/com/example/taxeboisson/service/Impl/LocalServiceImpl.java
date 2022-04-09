package com.example.taxeboisson.service.Impl;

import com.example.taxeboisson.bean.CategorieLocal;
import com.example.taxeboisson.bean.Local;
import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.Secteur;
import com.example.taxeboisson.dao.LocalDao;
import com.example.taxeboisson.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocalServiceImpl implements LocalService {

    @Autowired
    private LocalDao localDao;
    @Autowired
    private RedevableService redevableService;
    @Autowired
    private SecteurService secteurService;
    @Autowired
    private CategorieLocalService categorieLocalService;
    @Autowired
    private TaxeBoissonService taxeBoissonService;

    private void prepare(Local local) {

        Redevable redevable = redevableService.findByCin(local.getRedevable().getCin());
        if (redevable != null)
            local.setRedevable(redevable);
        Secteur secteur = secteurService.findByCode(local.getSecteur().getCode());
        if (secteur != null)
            local.setSecteur(secteur);
        CategorieLocal categorieLocal = categorieLocalService.findByCode(local.getCategorieLocal().getCode());
        if (categorieLocal != null)
            local.setCategorieLocal(categorieLocal);
    }


    private int validate(Local local) {

        Redevable redevable = redevableService.findByCin(local.getRedevable().getCin());
        Secteur secteur = secteurService.findByCode(local.getSecteur().getCode());
        CategorieLocal categorieLocal = categorieLocalService.findByCode(local.getCategorieLocal().getCode());

        if (findByRef(local.getRef()) != null) {
            return -1;
        } else if (redevable == null) {
            return -2;
        } else if (categorieLocal == null) {
            return -3;
        } else if (secteur == null) {
            return -4;
        } else {
            return 1;
        }

    }

    @Override
    public int exec(Local local){
        prepare(local);
        int res = validate(local);
        if (res < 0){
            return res;
        }else {
            localDao.save(local);
            return 1;
        }
    }

    @Override
    public Local findByRef(String ref) {
        return localDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return localDao.deleteByRef(ref);
    }

    @Override
    public List<Local> findByCategorieLocalCode(String code) {
        return localDao.findByCategorieLocalCode(code);
    }

    @Override
    @Transactional
    public int deleteByCategorieLocalCode(String code) {
        return localDao.deleteByCategorieLocalCode(code);
    }

    @Override
    public List<Local> findByRedevableCin(String cin) {
        return localDao.findByRedevableCin(cin);
    }

    @Override
    @Transactional
    public int deleteByRedevableCin(String cin) {
        return localDao.deleteByRedevableCin(cin);
    }

    @Override
    public List<Local> findBySecteurCode(String code) {
        return localDao.findBySecteurCode(code);
    }

    @Override
    @Transactional
    public int deleteBySecteurCode(String code) {
        return localDao.deleteBySecteurCode(code);
    }

    @Override
    @Transactional
    public int deleteLocalWithTaxes(String ref) {
        int res1 = taxeBoissonService.deleteByLocalRef(ref);
        int res2 = localDao.deleteByRef(ref);
        return res1+res2;
    }

    @Override
    public Local findByAdresse(String adresse) {
        return localDao.findByAdresse(adresse);
    }

    @Override
    @Transactional
    public int deleteByAdresse(String adresse) {
        return localDao.deleteByAdresse(adresse);
    }

    @Override
    public Local findByRue(String rue) {
        return localDao.findByRue(rue);
    }

    @Override
    @Transactional
    public int deleteByRue(String rue) {
        return localDao.deleteByRue(rue);
    }
}
