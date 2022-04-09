package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalDao extends JpaRepository<Local,Long> {

    Local findByRef(String ref);
    int deleteByRef(String ref);

    List<Local> findByCategorieLocalCode(String code);
    int deleteByCategorieLocalCode(String code);

    List<Local> findByRedevableCin(String cin);
    int deleteByRedevableCin(String cin);

    List<Local> findBySecteurCode(String code);
    int deleteBySecteurCode(String code);

    int deleteLocalWithTaxes(String ref);


}
