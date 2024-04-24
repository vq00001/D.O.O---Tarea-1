package Clases.Bebidas;

/**
 * Clase que representa una bebida de tipo Fanta
 * @autor Antonio Benavides
 */
public class Fanta extends Bebida{
    /**
     * Asigna el numero de serie al producto Fanta
     * @param numSerie Numero de serie del producto
     */
    public Fanta(int numSerie){super(numSerie);}

    /**
     * Funcion que retorna el gesto de consumir el producto en formato "String"
     * @return String con el gesto de consumir el producto
     */
    public String consumir(){return super.consumir() +"fanta";}
}