package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.CategorieLocal;

public interface CategorieLocalService {

    CategorieLocal findByCode(String ref);
    int deleteByCode(String ref);
}
