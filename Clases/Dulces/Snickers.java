package Clases.Dulces;

public class Snickers extends Dulce{
    //DECLARACIONES DE METODOS
    public Snickers(int x){super(x);} //Constructor: Asigna el numero de serie al producto
    public String consumir(){return super.consumir() + "snickers";} //Funcion que retorna el sonido de consumir el producto en formato "String"
}
