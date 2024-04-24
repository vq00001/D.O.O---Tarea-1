package Clases.Monedas;
import java.lang.Comparable;    //Importacion de la interfaz Comparable

/**
 * Clase abstracta que representa una moneda
 * @author Valeria Quiroga
 * @autor Antonio Benavides
 */
public abstract class Moneda implements Comparable<Moneda>{
    /**
     * Constructor de la clase Moneda Vacio
     */
    public Moneda(){}

    /**
     * Funcion que retorna la referencia a si mismo
     * @return Referencia a si mismo
     */
    public Moneda getSerie(){return this;}

    /**
     * Funcion que retorna el valor de la moneda
     * @return Valor de la moneda
     */
    public abstract int getValor();

    /**
     * Funcion que compara dos monedas
     * @param m Moneda a comparar
     * @return Diferencia entre los valores de las monedas
     */
    public int compareTo(Moneda m){
        return this.getValor()-m.getValor();   
    }
}
