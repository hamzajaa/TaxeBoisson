package com.example.taxeboisson.service.Impl;

import com.example.taxeboisson.bean.CategorieLocal;
import com.example.taxeboisson.dao.CategorielLocalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorielLocalServiceImpl {

    @Autowired
    private CategorielLocalDao categorielLocalDao;





    public CategorieLocal findByCode(String ref) {
        return categorielLocalDao.findByCode(ref);
    }

    public int deleteByCode(String ref) {
        return categorielLocalDao.deleteByCode(ref);
    }


}
