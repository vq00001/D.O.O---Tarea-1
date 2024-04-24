package Clases.Dulces;
import Clases.Producto;

/**
 * Clase abstracta que representa un dulce generico
 * @author Antonio Benavides
 */
public abstract class Dulce extends Producto{
    /**
     * Asigna el numero de serie al producto Dulce
     * @param x Numero de serie del producto
     */
    public Dulce(int x){super(x);}

    /**
     * Funcion que retorna el gesto de consumir el producto en formato "String", el producto que se consume se agrega en la subclase
     * @return String con el gesto de consumir el producto
     */
    public String consumir(){return "Se come el ";}
}