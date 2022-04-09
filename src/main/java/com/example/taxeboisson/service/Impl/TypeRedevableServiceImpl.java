package com.example.taxeboisson.service.Impl;

import com.example.taxeboisson.bean.TypeRedevable;
import com.example.taxeboisson.dao.TypeRedevableDao;
import com.example.taxeboisson.service.facade.RedevableService;
import com.example.taxeboisson.service.facade.TypeRedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypeRedevableServiceImpl implements TypeRedevableService {

    @Autowired
    private TypeRedevableDao typeRedevableDao;
    @Autowired
    @Lazy
    private RedevableService redevableService;


    @Override
    public int save(TypeRedevable typeRedevable) {
        if (findByCode(typeRedevable.getCode()) != null) {
            return -1;
        } else {
            typeRedevableDao.save(typeRedevable);
            return 1;
        }
    }

    @Override
    public TypeRedevable findByCode(String code) {
        return typeRedevableDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return typeRedevableDao.deleteByCode(code);
    }

    @Override
    @Transactional
    public int deleteTypewhithsRedevables(String code) {
        int res1 = redevableService.deleteByTypeRedevableCode(code);
        int res2 =  typeRedevableDao.deleteByCode(code);
        return res1+res2;
    }
}
