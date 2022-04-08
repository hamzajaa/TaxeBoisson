package com.example.taxeboisson.service.Impl;

import com.example.taxeboisson.bean.CategorieLocal;
import com.example.taxeboisson.dao.CategorielLocalDao;
import com.example.taxeboisson.service.facade.CategorieLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorielLocalServiceImpl implements CategorieLocalService {

    @Autowired
    private CategorielLocalDao categorielLocalDao;

    @Override
    public int save(CategorieLocal categorieLocal) {
        if (findByCode(categorieLocal.getCode()) != null) {
            return -1;
        } else {
            categorielLocalDao.save(categorieLocal);
            return 1;
        }
    }

    @Override
    public CategorieLocal findByCode(String ref) {
        return categorielLocalDao.findByCode(ref);
    }

    @Override
    public int deleteByCode(String ref) {
        return categorielLocalDao.deleteByCode(ref);
    }
}
