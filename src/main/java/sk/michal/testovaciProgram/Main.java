package sk.michal.testovaciProgram;

import sk.michal.ormSimpleFramework.dbaccess.SormManager;
import sk.michal.testovaciProgram.entity.Osoba;

public class Main {
    public static void main(String[] args) {
        SormManager manager = new SormManager();
        Osoba osoba =manager.getEntityByid(6L, Osoba.class);

    }
}
