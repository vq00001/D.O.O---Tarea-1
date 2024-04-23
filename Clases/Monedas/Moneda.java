package Clases.Monedas;
import java.lang.Comparable;    //Importacion de la interfaz Comparable

public abstract class Moneda implements Comparable<Moneda>{
    public Moneda(){}   //Constructor vasio
    public Moneda getSerie(){return this;} //Funsion que retorna la referencia a si mismo
    public abstract int getValor();     //Definision de una funcion para que retorne el valor de la moneda que representa
    public int compareTo(Moneda m){     //Funcion que compara dos monedas
        return this.getValor()-m.getValor();    //Retorna la diferencia entre los valores de las monedas, si es positivo la moneda actual es mayor, si es negativo la moneda actual es menor, si es 0 son iguales
    }
}
