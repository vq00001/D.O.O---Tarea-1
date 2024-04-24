package Clases.Excepciones;

/**
 * PagoIncorrectoException es una excepción que se lanza cuando no se a ingresado una moneda para realizar el pago
 * @author Valeria Quiroga
 */
public class PagoIncorrectoException extends Exception{
    /**
     * Asigna un mensaje a la excepción que luego se mostrará en la terminal por el canal de error
     * @param message Mensaje que se mostrará en la terminal
     */
    public PagoIncorrectoException (String message){
        super(message);
    }
}
