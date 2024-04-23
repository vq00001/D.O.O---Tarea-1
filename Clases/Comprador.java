package Clases;

import Clases.Monedas.*;    //Importacion de todas las clases de Moneda (100,500,1000,1500)
import Clases.Producto;    //Importacion de la clase Producto
import Clases.Excepciones.*;    //Importacion de todas las clases de Excepciones (PagoIncorrectoException,PagoInsuficienteException,NoHayProductoException)
import Clases.Precios_Productos;    //Importacion de la clase Precios_Productos


public class Comprador{
    //DECLARACIONES DE ATRIBUTOS
    private String sonido;  //Guarda el sonido/gesto de consumir el producto comprado
    private int vuelto = 0; //Guarda el valor numeroco (int) del vuelto resibido al comprar el producto

    //DECLARACIONES DE METODOS
    //Constructor: recibe la moneda con la que comprara, un numero que identifica el tipo de producto y la referencia al Expendedor en el que comprara

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

    public int cuantoVuelto() {return vuelto;}      //Funcion que retorna el vuelto como un valor "int"
    public String queConsumiste() {return sonido;}  //Funcion que retorna el sonido de consumir el producto comprado en formato "String"
}
