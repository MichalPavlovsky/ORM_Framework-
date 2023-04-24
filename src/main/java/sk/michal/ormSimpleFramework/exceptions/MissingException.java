package sk.michal.ormSimpleFramework.exceptions;

public class MissingException extends RuntimeException{
    public MissingException(String message) {
        super(message);
    }
}
