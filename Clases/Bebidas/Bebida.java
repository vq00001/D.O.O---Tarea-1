package Clases.Bebidas;

import Clases.Producto;

public abstract class Bebida extends Producto{
    //DECLARACIONES DE METODOS
    //Constructor: Asigna el nuemro de serie a la bebida
    public Bebida(int x){super(x);}

    public String consumir(){return "Se bebe la ";};      //Funcion beber que retorna el sonido/gesto de beberse la bebida
}
