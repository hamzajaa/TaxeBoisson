package com.example.taxeboisson.service.facade;


import com.example.taxeboisson.bean.Redevable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RedevableService {

    int save(Redevable redevable);

    Redevable findByCin(String cin);
    int deleteByCin(String cin);

    List<Redevable> findByTypeRedevableCode(String code);
    int deleteByTypeRedevableCode(String code);

    @Transactional
    int deleteRedevableWithLocalAndTa(String cin);
}
