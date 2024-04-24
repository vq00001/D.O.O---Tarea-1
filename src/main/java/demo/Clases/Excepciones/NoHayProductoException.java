package demo.Clases.Excepciones;

public class NoHayProductoException extends Exception{
    public NoHayProductoException (String message){
        super(message);
    }
}
