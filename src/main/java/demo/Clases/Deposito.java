package demo.Clases;

import java.util.ArrayList;     //Importacion de la clase ArrayList

public class Deposito<T>{
    //DECLARACIONES DE ATRIBUTOS
    ArrayList<T> list; //Definicion de la lista que guardara a las productos

    //DECLARACIONES DE METODOS
    //Constructor: Instanciacion de la lista que guardara a las productos
    public Deposito() {list = new ArrayList<T>();}
    
    public void add(T x) {list.add(x);}  //Funcion para agregar productos a la lista
    
    public T get(){  //Funcion para retirar productos de la lista
        if (list.size() != 0) {return list.remove(0);}  //Si la lista no esta vacia se retorna al primera producto de la lista eliminadolo a la ves de esta lista
        else return null;       //Si la lista esta vacia se retorna null
    }
}
