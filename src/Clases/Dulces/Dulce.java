package Clases.Dulces;
import Clases.Producto;

public abstract class Dulce extends Producto{
    //DECLARACIONES DE METODOS
    public Dulce(int x){super(x);} //Constructor: Asigna el numero de serie al producto

    public String consumir(){return "Se come el ";} //Funcion que retorna el sonido de consumir el producto en formato "String"
}
