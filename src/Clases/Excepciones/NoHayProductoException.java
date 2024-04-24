package Clases.Excepciones;

/**
 * NoHayProductoException es una excepción que se lanza cuando esta vacio el deposito del producto que se quiere comprar
 * @author Valeria Quiroga 
 */
public class NoHayProductoException extends Exception{
    /**
     * Asigna un mensaje a la excepción que luego se mostrará en la terminal por el canal de error
     * @param message Mensaje que se mostrará en la terminal
     */
    public NoHayProductoException (String message){
        super(message);
    }
}
