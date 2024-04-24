package Clases.Excepciones;

/**
 * PagoInsuficienteException es una excepción que se lanza cuando el pago ingresado no es suficiente para comprar el producto que se quiere adquirir
 * @author Valeria Quiroga
 */
public class PagoInsuficienteException extends Exception{
    /**
     * Asigna un mensaje a la excepción que luego se mostrará en la terminal por el canal de error
     * @param message Mensaje que se mostrará en la terminal
     */
    public PagoInsuficienteException (String message){
        super(message);
    }
}
