package sk.michal.testovaciProgram;

import sk.michal.ormSimpleFramework.dbaccess.SormManager;

import sk.michal.testovaciProgram.entity.Film;
import sk.michal.testovaciProgram.entity.Osoba;


public class Main {
    public static void main(String[] args) throws Exception {
        SormManager manager = new SormManager();
        Osoba osoba =manager.getEntityByid(0L, Osoba.class);
        Film f =manager.getEntityByid(1L, Film.class);
        System.out.println(osoba.getId());
        System.out.println(osoba.getMeno());
        System.out.println(osoba.getPriezvisko());
        System.out.println(osoba.getVek());
        System.out.println(osoba.getAdresa());

        Film film = new Film();
        film.setId(0L);
        film.setNazov("Fireproof");
        film.setReziser("Alex Kendrick");
        film.setvHlavnejUlohe("Kirk Cameron, Erin Beythea");
        manager.insertEntity(film);




    }
}
