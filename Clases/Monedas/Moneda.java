package Clases.Monedas;

public abstract class Moneda{
    public Moneda(){}   //Constructor vasio
    public Moneda getSerie(){return this;} //Funsion que retorna la referencia a si mismo
    public abstract int getValor();     //Definision de una funcion para que retorne el valor de la moneda que representa
}
