package main.java.Clases.Excepciones;

public class PagoInsuficienteException extends Exception{
    public PagoInsuficienteException (String message){
        super(message);
    }
}