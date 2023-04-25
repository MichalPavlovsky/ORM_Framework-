package sk.michal.testovaciProgram;

import sk.michal.ormSimpleFramework.dbaccess.SormManager;
import sk.michal.testovaciProgram.entity.Osoba;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        SormManager manager = new SormManager();
        Osoba osoba =manager.getEntityByid(0L, Osoba.class);
        System.out.println(osoba.getId());
        System.out.println(osoba.getMeno());
        System.out.println(osoba.getPriezvisko());
        System.out.println(osoba.getVek());
        System.out.println(osoba.getAdresa());

    }
}
