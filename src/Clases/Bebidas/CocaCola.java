package Clases.Bebidas;

/**
 * Clase que representa una bebida de tipo CocaCola
 * @author Valeria Quiroga
 * @autor Antonio Benavides
 */
public class CocaCola extends Bebida{
    /**
     * Asigna el numero de serie al producto CocaCola
     * @param numSerie Numero de serie del producto
     */
    public CocaCola(int numSerie){super(numSerie);}

    /**
     * Funcion que retorna el gesto de consumir el producto en formato "String"
     * @return String con el gesto de consumir el producto
     */
    public String consumir(){return super.consumir() + "cocacola";}
}