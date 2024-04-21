package Clases.Bebidas;

public abstract class Bebida{
    //DECLARACIONES DE ATRIBUTOS
    private int numSerie;   //Variable que almacena el numero de serie de las bebidas

    //DECLARACIONES DE METODOS
    //Constructor: Asigna el nuemro de serie a la bebida
    public Bebida(int x){numSerie = x;}

    public int getSerie(){return numSerie;} //Funcion que retorna el numero de serie de la bebida
    
    public abstract String beber();         //Declaracion abstracta de la funcion beber, que retornara el sonido/gesto de beberse la bebida
}
