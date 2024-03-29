package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.Redevable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedevableDao extends JpaRepository<Redevable, Long> {

    Redevable findByCin(String cin);
    int deleteByCin(String cin);

    List<Redevable> findByTypeRedevableCode(String code);
    int deleteByTypeRedevableCode(String code);




}
