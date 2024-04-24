package Clases;

/**
 * Clase abstracta que representa un producto
 * @autor Antonio Benavides
 */
public abstract class Producto {
    //DECLARACIONES DE ATRIBUTOS
    /**
     * Variable que almacena el numero de serie del producto
     */
    protected int numSerie;

    //DECLARACIONES DE METODOS
    /**
     * Constructor de la clase Producto que asigna el numero de serie al producto
     * @param x Numero de serie del producto
     */
    public Producto(int x){numSerie = x;}

    /**
     * Funcion que retorna el numero de serie del producto
     * @return Numero de serie del producto
     */
    public int getSerie(){return numSerie;}

    /**
     * Funcion abstracta que retorna el sonido/gesto de consumirse el producto
     * @return Sonido/gesto de consumirse el producto
     */
    public abstract String consumir();
}