package br.com.igormartinez.cambioservice.exceptions;

public class UnsupportedCurrencyException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public UnsupportedCurrencyException(String message) {
        super(message);
    }
}
