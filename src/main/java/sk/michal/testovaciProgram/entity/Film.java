package sk.michal.testovaciProgram.entity;

import sk.michal.ormSimpleFramework.anotacie.Id;
import sk.michal.ormSimpleFramework.anotacie.Stlpec;
import sk.michal.ormSimpleFramework.anotacie.Tabulka;

@Tabulka("MOVIE")
public class Film {
    @Id
    @Stlpec("ID")
    private Long id;
    @Stlpec("NAZOV_FILMU")
    private String nazov;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getReziser() {
        return reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public String getvHlavnejUlohe() {
        return vHlavnejUlohe;
    }

    public void setvHlavnejUlohe(String vHlavnejUlohe) {
        this.vHlavnejUlohe = vHlavnejUlohe;
    }

    @Stlpec("REZISER")
    private String reziser;

    @Stlpec("HLAVNA_ULOHA")
    private String vHlavnejUlohe;

}
