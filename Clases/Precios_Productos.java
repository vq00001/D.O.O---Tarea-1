package Clases;

public enum Precios_Productos{  //Enumeracion que representa los productos que se pueden comprar
    COCACOLA(100),           //Constante que contiene el precio de la CocaCola
    SPRITE(200),             //Constante que contiene el precio de la Sprite
    FANTA(300),              //Constante que contiene el precio de la Fanta
    SNICKERS(400),           //Constante que contiene el precio del Snickers
    SUPER8(500);             //Constante que contiene el precio del Super8

    private final int precio;    //Variable que guarda el valor numerico de la constante

    Precios_Productos(int valor) {this.precio = valor;}  //Constructor de la enumeracion que asigna el valor numerico a la constante

    public int getPrecio() {return precio;}     //Funcion que retorna el valor numerico de la constante
};