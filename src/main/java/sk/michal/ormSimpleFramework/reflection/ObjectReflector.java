package sk.michal.ormSimpleFramework.reflection;

import sk.michal.ormSimpleFramework.anotacie.Id;
import sk.michal.ormSimpleFramework.anotacie.Stlpec;
import sk.michal.ormSimpleFramework.anotacie.Tabulka;
import sk.michal.ormSimpleFramework.exceptions.MissingException;
import sk.michal.ormSimpleFramework.exceptions.MissingStlpecAnnotationException;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ObjectReflector {
    public static <T> boolean isTable(Class<T> clazz) {
        return clazz.isAnnotationPresent(Tabulka.class);
    }

    public static <T> String getTableName(Class<T> clazz) {
        return clazz.getAnnotation(Tabulka.class).value();
    }

    public static <T> List<String> getColumnNames(Class<T> clazz) {
        List<String> stlpce = new ArrayList<>();
        for (Field f : clazz.getDeclaredFields()) { // privatne
            if (f.isAnnotationPresent(Stlpec.class)) {
                Stlpec stlpec = f.getAnnotation(Stlpec.class);
                stlpce.add(stlpec.value());
                System.out.println("Stlpec: " + stlpec.value());
            }
        }
        return stlpce;
    }

    public static <T> String getIdColumnName(Class<T> clazz) {
        String idColumnName = null;
        for (Field f : clazz.getDeclaredFields()) {
            if (f.isAnnotationPresent(Id.class)) {
                if (f.isAnnotationPresent(Stlpec.class)) {
                    idColumnName = f.getAnnotation(Stlpec.class).value();
                } else {
                    throw new MissingStlpecAnnotationException("Pri hladani ID sa nenasiel stlpec oanotovany ako Stlpec");
                }
            }
        }
        if (idColumnName == null)
            throw new MissingException("Chyba anotacia Id v entite" + clazz.getName());
        System.out.println("Stlpec s ID: " + idColumnName);

        return idColumnName;
    }

    public static <T> T getFilledData(ResultSet result, Class<T> clazz) throws Exception {
        T object = null;
        object = clazz.newInstance();
        for (Field f : object.getClass().getDeclaredFields()) {
            f.setAccessible(true); //mozem upravovat privatny field
            if (f.isAnnotationPresent(Stlpec.class)) {
                String typElementu = f.getType().getName();
                String nazovStlpca = f.getAnnotation(Stlpec.class).value();
                if (typElementu.equals(String.class.getName())) {
                    f.set(object, result.getString(nazovStlpca));

                } else if (typElementu.equals(Long.class.getName())) {
                    f.set(object, result.getLong(nazovStlpca));
                } else if (typElementu.equals(Integer.class.getName())) {
                    f.set(object, result.getInt(nazovStlpca));

                }
            }

        }
        return object;
    }
}
