package Clases.Bebidas;

public class Sprite extends Bebida{
    public Sprite(int numSerie){super(numSerie);}   //Constructor que utiliza al constructor de su clase Padre Bebida
    public String consumir(){return "sprite";};        //Funcion beber que retorna el sonido/gesto de beberse la bebida
}