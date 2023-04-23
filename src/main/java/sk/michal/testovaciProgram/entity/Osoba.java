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
    private int vek;

    @Stlpec("ADDRESS")
    private String adresa;

}
