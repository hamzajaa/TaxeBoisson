package com.example.taxeboisson.service.facade;


import com.example.taxeboisson.bean.TypeRedevable;
import org.springframework.transaction.annotation.Transactional;

public interface TypeRedevableService {

    int save(TypeRedevable typeRedevable);

    TypeRedevable findByCode(String code);
    int deleteByCode(String code);


    int deleteTypewhithsRedevables(String code);
}
