package com.example.taxeboisson.bean;

import javax.persistence.*;

@Entity
public class CategorieLocal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String code;
    private String libelle;

    @OneToOne
    private TauTaxeLocal tauTaxeLocal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TauTaxeLocal getTauTaxeLocal() {
        return tauTaxeLocal;
    }

    public void setTauTaxeLocal(TauTaxeLocal tauTaxeLocal) {
        this.tauTaxeLocal = tauTaxeLocal;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
