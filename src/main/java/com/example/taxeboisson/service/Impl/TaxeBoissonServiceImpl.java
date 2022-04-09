package com.example.taxeboisson.service.Impl;

import com.example.taxeboisson.bean.Local;
import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.TauTaxeLocal;
import com.example.taxeboisson.bean.TaxeBoisson;
import com.example.taxeboisson.dao.TaxeBoissonDao;
import com.example.taxeboisson.service.facade.LocalService;
import com.example.taxeboisson.service.facade.RedevableService;
import com.example.taxeboisson.service.facade.TauTaxeLocalService;
import com.example.taxeboisson.service.facade.TaxeBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
public class TaxeBoissonServiceImpl implements TaxeBoissonService {

    @Autowired
    private TaxeBoissonDao taxeBoissonDao;
    @Autowired
    private LocalService localService;
    @Autowired
    private RedevableService redevableService;
    @Autowired
    private TauTaxeLocalService tauTaxeLocalService;

    public void prepare(TaxeBoisson tx) {
        Local local = localService.findByRef(tx.getLocal().getRef());
        if (local != null)
            tx.setLocal(local);
        Redevable redevable = redevableService.findByCin(tx.getRedevable().getCin());
        if (redevable != null)
            tx.setRedevable(redevable);
    }

    @Override
    public int save(TaxeBoisson taxeBoisson) {
        prepare(taxeBoisson);
        Local local = localService.findByRef(taxeBoisson.getLocal().getRef());
        Redevable redevable = redevableService.findByCin(taxeBoisson.getRedevable().getCin());
        int anneeActuelle = Calendar.getInstance().get(Calendar.YEAR);

        if (findByRef(taxeBoisson.getRef()) != null) {
            return -1;
        } else if (local == null || local.getRef().isEmpty()) {
            return -2;
        } else if (redevable == null || redevable.getCin().isEmpty()) {
            return -3;
        } else if (taxeBoisson.getAnnee() > anneeActuelle) {
            return -4;
        } else if (taxeBoisson.getChiffreAffaire() <= 0) {
            return -5;
        } else {
            calculMontant(taxeBoisson);
            taxeBoissonDao.save(taxeBoisson);
            return 1;
        }
    }

    public void calculMontant(TaxeBoisson tx) {
        TauTaxeLocal tauTaxeLocal = tauTaxeLocalService.findByCategorieLocalCode(tx.getLocal().getCategorieLocal().getCode());
        tx.setPourcentageApplique(tauTaxeLocal.getPourcentage());
        tx.setMontantBase(tx.getPourcentageApplique() * tx.getChiffreAffaire());
    }


    @Override
    public TaxeBoisson findByRef(String ref) {
        return taxeBoissonDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return taxeBoissonDao.deleteByRef(ref);
    }

    @Override
    public TaxeBoisson findByAnnee(int annee) {
        return taxeBoissonDao.findByAnnee(annee);
    }

    @Override
    @Transactional
    public int deleteByAnnee(int annee) {
        return taxeBoissonDao.deleteByAnnee(annee);
    }

    @Override
    @Transactional
    public int deleteByRedevableCin(String cin) {
        return taxeBoissonDao.deleteByRedevableCin(cin);
    }

    @Override
    public List<TaxeBoisson> findByLocalRef(String ref) {
        return taxeBoissonDao.findByLocalRef(ref);
    }

    @Override
    @Transactional
    public int deleteByLocalRef(String ref) {
        return taxeBoissonDao.deleteByLocalRef(ref);
    }
}
