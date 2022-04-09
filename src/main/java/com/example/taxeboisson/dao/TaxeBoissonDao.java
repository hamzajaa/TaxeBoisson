package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.TaxeBoisson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxeBoissonDao extends JpaRepository<TaxeBoisson,Long> {

    TaxeBoisson findByRef(String ref);
    int deleteByRef(String  ref);

    TaxeBoisson findByAnnee(int annee);
    int deleteByAnnee(int annee);

    int deleteByRedevableCin(String cin);

    List<TaxeBoisson> findByLocalRef(String ref);
    int deleteByLocalRef(String ref);



}
