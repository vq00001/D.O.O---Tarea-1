package Clases.Dulces;

/**
 * Clase que representa un dulce de tipo Super8
 * @autor Antonio Benavides
 */
public class Super8 extends Dulce{
    /**
     * Asigna el numero de serie al producto Super8
     * @param x Numero de serie del producto
     */
    public Super8(int x){super(x);}

    /**
     * Funcion que retorna el gesto de consumir el producto en formato "String"
     * @return String con el gesto de consumir el producto
     */
    public String consumir(){return super.consumir() + "super8";}
}
