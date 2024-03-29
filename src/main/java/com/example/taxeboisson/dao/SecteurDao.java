package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecteurDao extends JpaRepository<Secteur, Long> {

    Secteur findByCode(String code);
    int deleteByCode(String code);

    Secteur findByLibelle(String libelle);
    int deleteByLibelle(String libelle);
}
