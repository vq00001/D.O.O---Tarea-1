package Clases;

/**
 * Enumeracion que representa los productos que se pueden comprar y sus precios
 * @author Antonio Benavides
 */
public enum Precios_Productos{
    /**
     * Precio de la CocaCola
     */
    COCACOLA(100),

    /**
     * Precio de la Pepsi
     */
    SPRITE(200),

    /**
     * Precio de la Fanta
     */
    FANTA(300),

    /**
     * Precio del Snickers
     */
    SNICKERS(400),

    /**
     * Precio del Super8
     */
    SUPER8(500);

    private final int precio;    //Variable que guarda el valor numerico de la constante

    /**
     * Constructor de la enumeracion que asigna el precio a los productos
     * @param valor Precio del producto
     */
    Precios_Productos(int valor) {this.precio = valor;}

    /**
     * Funcion que retorna el precio del producto
     * @return Precio del producto
     */
    public int getPrecio() {return precio;}
};