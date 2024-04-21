package Clases.Depositos;

import Clases.Bebidas.Bebida;   //Importacion de la clase Bebida
import java.util.ArrayList;     //Importacion de la clase ArrayList

public class Deposito{
    //DECLARACIONES DE ATRIBUTOS
    ArrayList<Bebida> list; //Definicion de la lista que guardara a las bebidas

    //DECLARACIONES DE METODOS
    //Constructor: Instanciacion de la lista que guardara a las bebidas
    public Deposito() {list = new ArrayList<Bebida>();}
    
    public void addBebida(Bebida x) {list.add(x);}  //Funcion para agregar bebidas a la lista
    
    public Bebida getBebida(){  //Funcion para retirar bebidas de la lista
        if (list.size() != 0) {return list.remove(0);}  //Si la lista no esta vasia se retorna la primera bebida de la lista eliminadola a la ves de esta lista
        else return null;       //Si la lista esta vasia se retorna null
    }
}
