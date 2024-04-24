package main.java.Clases.Bebidas;

public class CocaCola extends Bebida{
    public CocaCola(int numSerie){super(numSerie);} //Constructor que utiliza al constructor de su clase Padre Bebida
    public String consumir(){return super.consumir() + "cocacola";};      //Funcion beber que retorna el sonido/gesto de beberse la bebida
}
