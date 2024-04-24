package demo.Clases.Dulces;

public class Super8 extends Dulce{
    //DECLARACIONES DE METODOS
    public Super8(int x){super(x);} //Constructor: Asigna el numero de serie al producto
    public String consumir(){return super.consumir() + "super8";} //Funcion que retorna el sonido de consumir el producto en formato "String"
}
