package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalDao extends JpaRepository<Local,Long> {

    Local findByRef(String ref);
    int deleteByRef(String ref);

    List<Local> findByCategorieLocalRef(String ref);
    int deleteByCategorieLocalRef(String ref);

    List<Local> findByRedevableRef(String ref);
    int deleteByRedevableRef(String ref);

    List<Local> findBySecteurCode(String code);
    int deleteBySecteurCode(String code);


}
