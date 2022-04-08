package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.CategorieLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorielLocalDao extends JpaRepository<CategorieLocal, Long> {

    CategorieLocal findByCode(String ref);
    int deleteByCode(String ref);

}
