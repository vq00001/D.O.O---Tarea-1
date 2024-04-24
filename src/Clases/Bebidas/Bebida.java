package Clases.Bebidas;
import Clases.Producto;

/**
 * Clase abstracta que representa una bebida
 * @autor Valeria Quiroga
 * @autor Antonio Benavides
 */
public abstract class Bebida extends Producto{
    //DECLARACIONES DE METODOS
    /**
     * Constructor de la clase Bebida que asigna el numero de serie a la bebida
     * @param x Numero de Serie de la bebida
     */
    public Bebida(int x){super(x);}

    /**
     * Funcion que retorna el sonido/gesto de beberse la bebida
     * @return Sonido/gesto de beberse la bebida
     */
    public String consumir(){return "Se bebe la ";}
}
