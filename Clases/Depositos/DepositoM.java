package Clases.Depositos;

import Clases.Monedas.Moneda;   //Importacion de la clase Moneda
import java.util.ArrayList;     //Importacion de la clase ArrayList

public class DepositoM{
    //DECLARACIONES DE ATRIBUTOS
    ArrayList<Moneda> list;    //Definicion de la lista que guardara a las monedas del vuelto
    
    //DECLARACIONES DE METODOS
    //Constructor: Instanciacion de la lista que guardara a las monedas del vuelto
    public DepositoM(){list = new ArrayList<Moneda>();}
    
    public void addMoneda(Moneda x){list.add(x);}   //Funcion para agregar las monedas del vuelto a la lista
    
    public Moneda getMoneda(){      //Funcion para retirar las monedas del vuelto de la lista
        if (list.size() > 0) {return list.remove(0);}   //Si la lista no esta vasia se retorna la primera moneda del vuelto de la lista eliminadola a la ves de esta lista
        else return null;   //Si la lista esta vasia se retorna null
    }
}
