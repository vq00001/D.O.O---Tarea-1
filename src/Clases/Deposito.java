package Clases;

import java.util.ArrayList;     //Importacion de la clase ArrayList

/**
 * Clase que representa un deposito de productos
 * @param <T> Tipo de producto que se guardara en el deposito
 * @author Valeria Quiroga
 * @author Antonio Benavides
 */
public class Deposito<T>{
    //DECLARACIONES DE ATRIBUTOS//
    /**
     * Lista que guardara a las productos
     */
    ArrayList<T> list;

    //DECLARACIONES DE METODOS//
    /**
     * Constructor de la clase Deposito que instancia la lista que guardara a las productos
     */
    public Deposito() {list = new ArrayList<T>();}

    /**
     * Funcion que agrega un producto a la lista
     * @param x Producto a agregar
     */
    public void add(T x) {list.add(x);}

    /**
     * Funcion que retorna el primer producto de la lista
     * @return Primer producto de la lista
     */
    public T get(){
        if (list.size() != 0) {return list.remove(0);}  //Si la lista no esta vacia se retorna al primera producto de la lista eliminadolo a la ves de esta lista
        else return null;       //Si la lista esta vacia se retorna null
    }
}
