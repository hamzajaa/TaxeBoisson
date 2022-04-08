package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.TauTaxeLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauTaxeLocalDao extends JpaRepository<TauTaxeLocal, Long> {

   TauTaxeLocal findByCode(String code);
   int deleteByCode(String code);

   TauTaxeLocal findByCategorieLocalCode(String code);
   int deleteByCategorieLocalCode(String code);


}
