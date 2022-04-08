package com.example.taxeboisson.service.facade;


import com.example.taxeboisson.bean.TypeRedevable;

public interface TypeRedevableService {

    int save(TypeRedevable typeRedevable);

    TypeRedevable findByCode(String code);
    int deleteByCode(String code);

}
