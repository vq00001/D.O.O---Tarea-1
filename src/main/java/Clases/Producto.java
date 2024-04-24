package main.java.Clases;

public abstract class Producto {
    //DECLARACIONES DE ATRIBUTOS
    protected int numSerie;   //Variable que almacena el numero de serie del producto

    //DECLARACIONES DE METODOS
    public Producto(int x){numSerie = x;}   //Constructor: Asigna el numero de serie al producto

    public int getSerie(){return numSerie;} //Funcion que retorna el numero de serie del producto

    public abstract String consumir();      //Declaracion abstracta de la funcion consumir, que retornara el sonido/gesto de consumirse el producto
}
