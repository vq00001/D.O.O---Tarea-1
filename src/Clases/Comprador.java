package Clases;

import Clases.Monedas.*;
import Clases.Producto;
import Clases.Excepciones.*;
import Clases.Precios_Productos;

/**
 * Clase que representa a un comprador
 * @autor Valeria Quiroga
 * @autor Antonio Benavides
 */
public class Comprador{
    //DECLARACIONES DE ATRIBUTOS
    private String sonido;  //Guarda el sonido/gesto de consumir el producto comprado
    private int vuelto = 0; //Guarda el valor numeroco (int) del vuelto resibido al comprar el producto

    //DECLARACIONES DE METODOS
    /**
     * Constructor de la clase Comprador que realiza la compra de un producto en un expendedor
     * @param moneda    Moneda con la que se comprara
     * @param cualProducto  Identificador del tipo de producto que se comprara
     * @param exp   Referencia al expendedor en el que se comprara
     * @throws PagoInsuficienteException Excepcion que se lanza si el valor de la moneda ingresada no es suficiente para comprar el producto
     * @throws PagoIncorrectoException   Excepcion que se lanza si la moneda ingresada no es valida
     * @throws NoHayProductoException   Excepcion que se lanza si no hay productos disponibles en el deposito del producto que se quiere comprar
     */
    public Comprador(Moneda moneda, Precios_Productos cualProducto, Expendedor exp) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException{

        Producto producto = null;

        try{
            producto = exp.comprarProducto(moneda, cualProducto);    //Se compra el producto en el expendedor entregandole la moneda y el numero que identifica el tipo de producto

        } catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e){
            throw e; // Lanzar la expresion nuevamente para que sea manejada en main.
        }


        //Bucle en que se asigna el vuelto
        while (true) {
            Moneda vueltoexp = exp.getVuelto();                 //Se extrae una moneda del deposito de vuelto del expendedor

            if (vueltoexp == null){break;}                      //Si no se extrajo ninguna moneda se sale del bucle, debido a esto vuelto queda en 0 debido a que no se modifico
            vuelto = vuelto + vueltoexp.getValor();             //Si se logro sacar una moneda, el valor de esa moneda se suma con el vuelto guardado en las iteraciones anteriores

            if (producto == null) {vuelto = moneda.getValor();break;}    //Si no se logro comprar un producto se asigna el valor de la moneda que uno ingreso, como que el expendedor la devolviera
        }

        //Gesto de consumir el producto
        if (producto == null) {     //Si no se logro conprar un producto:
            sonido = null;          //El sonido de consumir el producto queda como null

        } else {sonido = producto.consumir();}  //Si se logro consumir el producto se asigna el gesto/sonido de consumir el producto
    }

    /**
     * Funcion que retorna el vuelto
     * @return  Vuelto en formato numerico "int"
     */
    public int cuantoVuelto() {return vuelto;}

    /**
     * Funcion que retorna el sonido/gesto de consumir el producto comprado
     * @return  Sonido/gesto de consumir el producto en formato "String"
     */
    public String queConsumiste() {return sonido;}
}
