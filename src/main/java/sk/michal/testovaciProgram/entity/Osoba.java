package sk.michal.testovaciProgram.entity;

import sk.michal.ormSimpleFramework.anotacie.Id;
import sk.michal.ormSimpleFramework.anotacie.Stlpec;
import sk.michal.ormSimpleFramework.anotacie.Tabulka;

@Tabulka("OSOBA")
public class Osoba {
    @Id
    @Stlpec("ID")
    private Long id;

    @Stlpec("NAME")
    private String meno;

    @Stlpec("SURNAME")
    private String priezvisko;

    @Stlpec("AGE")
    private Integer vek;

    @Stlpec("ADDRESS")
    private String adresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public Integer getVek() {
        return vek;
    }

    public void setVek(Integer vek) {
        this.vek = vek;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
