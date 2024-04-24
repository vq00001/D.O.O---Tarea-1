package Clases.Dulces;

/**
 * Clase que representa un dulce de tipo Snickers
 * @author Antonio Benavides
 */
public class Snickers extends Dulce{
    /**
     * Asigna el numero de serie al producto Snickers
     * @param x Numero de serie del producto
     */
    public Snickers(int x){super(x);}

    /**
     * Funcion que retorna el gesto de consumir el producto en formato "String"
     * @return String con el gesto de consumir el producto
     */
    public String consumir(){return super.consumir() + "snickers";}
}
