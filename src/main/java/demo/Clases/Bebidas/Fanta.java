package demo.Clases.Bebidas;

public class Fanta extends Bebida{
    public Fanta(int numSerie){super(numSerie);}   //Constructor que utiliza al constructor de su clase Padre Bebida
    public String consumir(){return super.consumir() +"fanta";};        //Funcion beber que retorna el sonido/gesto de beberse la bebida
}
