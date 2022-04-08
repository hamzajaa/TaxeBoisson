package com.example.taxeboisson.service.Impl;

import com.example.taxeboisson.bean.Secteur;
import com.example.taxeboisson.dao.SecteurDao;
import com.example.taxeboisson.service.facade.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SecteurServiceImpl implements SecteurService {

    @Autowired
    private SecteurDao secteurDao;

    @Override
    public int save(Secteur secteur){
        if (findByCode(secteur.getCode()) != null){
            return -1;
        }else{
            secteurDao.save(secteur);
            return 1;
        }
    }

    @Override
    public Secteur findByCode(String code) {
        return secteurDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return secteurDao.deleteByCode(code);
    }
}
