package Clases.Bebidas;

/**
 * Clase que representa una bebida de tipo Sprite
 * @author Valeria Quiroga
 * @author Antonio Benavides
 */
public class Sprite extends Bebida{
    /**
     * Asigna el numero de serie al producto Sprite
     * @param numSerie Numero de serie del producto
     */
    public Sprite(int numSerie){super(numSerie);}

    /**
     * Funcion que retorna el gesto de consumir el producto en formato "String"
     * @return String con el gesto de consumir el producto
     */
    public String consumir(){return super.consumir() + "sprite";}
}