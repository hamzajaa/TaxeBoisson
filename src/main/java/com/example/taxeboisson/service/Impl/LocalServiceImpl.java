package com.example.taxeboisson.service.Impl;

import com.example.taxeboisson.bean.CategorieLocal;
import com.example.taxeboisson.bean.Local;
import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.Secteur;
import com.example.taxeboisson.dao.LocalDao;
import com.example.taxeboisson.service.facade.CategorieLocalService;
import com.example.taxeboisson.service.facade.LocalService;
import com.example.taxeboisson.service.facade.RedevableService;
import com.example.taxeboisson.service.facade.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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

    @Override
    public int save(Local local) {

        Redevable redevable = redevableService.findByCin(local.getRedevable().getCin());
        local.setRedevable(redevable);
        Secteur secteur = secteurService.findByCode(local.getSecteur().getCode());
        local.setSecteur(secteur);
        CategorieLocal categorieLocal = categorieLocalService.findByCode(local.getCategorieLocal().getCode());
        local.setCategorieLocal(categorieLocal);

        if (findByRef(local.getRef()) != null) {
            return -1;
        } else if (redevable == null) {
            return -2;
        } else if (categorieLocal == null) {
            return -3;
        } else if (secteur == null) {
            return -4;
        } else {
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
}
