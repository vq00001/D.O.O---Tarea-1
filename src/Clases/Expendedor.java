package Clases;

import Clases.*;
import Clases.Bebidas.*;
import Clases.Dulces.*;
import Clases.Monedas.*;
import Clases.Excepciones.*;

/**
 * Clase que representa un Expendedor de productos
 * @author Valeria Quiroga
 * @author Antonio Benavides
 */
public class Expendedor{
    //DECLARACIONES DE ATRIBUTOS
    private Deposito<Moneda> monVu;     //Deposito que guarda las monedas del vuelto
    private Deposito<Bebida> coca;      //Deposito que guarda las bebidas CocaCola
    private Deposito<Bebida> sprite;    //Deposito que guarda las bebidas Sprite
    private Deposito<Bebida> fanta;     //Deposito que guarda las bebidas Fanta
    private Deposito<Dulce> snickers;   //Deposito que guarda los dulces Snickers
    private Deposito<Dulce> super8;     //Deposito que guarda los dulces Super8

    //DECLARACIONES DE METODOS//
    /**
     * Constructor de la clase Expendedor que llena los depositos de bebidas y dulces
     * @param numProductos Cantidad de productos con la que se llenaran los depositos
     */
    public Expendedor(int numProductos)
    {
        monVu = new Deposito<Moneda>();     //Instanciacion del Deposito de Monedas
        coca = new Deposito<Bebida>();      //Instanciacion del Deposito de CocaColas
        sprite = new Deposito<Bebida>();    //Instanciacion del Deposito de Sprite
        fanta = new Deposito<Bebida>();     //Instanciacion del Deposito de Fanta
        snickers = new Deposito<Dulce>();   //Instanciacion del Deposito de Snickers
        super8 = new Deposito<Dulce>();     //Instanciacion del Deposito de Super8

        for (int i = 0; i < numProductos; i++) {      //For en que se rellenan los depositos con sus respectivasd monedas
            Bebida bc = new CocaCola(i);            //Se crea una CocaCola con su numero de serie
            coca.add(bc);                     //Se ingresa la bebida recien creada al deposito de CocaCola
            Bebida bs = new Sprite(numProductos+i);   //Se crea una Sprite con su numero de serie
            sprite.add(bs);                   //Se ingresa la bebida recien creada al deposito de Sprite
            Bebida bf = new Fanta(2*numProductos+i);   //Se crea una Fanta con su numero de serie
            fanta.add(bf);                   //Se ingresa la bebida recien creada al deposito de Fanta
            Dulce ds = new Snickers(3*numProductos+i);            //Se crea un Snickers con su numero de serie
            snickers.add(ds);                 //Se ingresa el dulce recien creado al deposito de Snickers
            Dulce d8 = new Super8(4*numProductos+i);   //Se crea un Super8 con su numero de serie
            super8.add(d8);                   //Se ingresa el dulce recien creado al deposito de Super8
        }
    }

    /**
     * Funcion que permite comprar productos del expendedor ingresando una moneda y el numero que indica el producto a comprar
     * @param moneda    Moneda con la que se comprara
     * @param cualProducto  Identificador del tipo de producto que se comprara
     * @return  Producto comprado
     * @throws PagoIncorrectoException   Excepcion que se lanza si no se ingreso una moneda o esta es invalida
     * @throws PagoInsuficienteException Excepcion que se lanza si el valor de la moneda ingresada no es suficiente para comprar el producto
     * @throws NoHayProductoException   Excepcion que se lanza si no hay productos disponibles en el deposito del producto que se quiere comprar
     */
    public Producto comprarProducto(Moneda moneda, Precios_Productos cualProducto) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{   //Funcion que permite comprar productos del expendedor ingresando una moneda y el numero que indica el producto a comprar

        Producto producto = null;                               //Se crea un puntero auxiliar de tipo Bebida nulo

        if (moneda == null) {throw new PagoIncorrectoException("No se ingreso moneda.");}  //Si no se ingreso una moneda se sale de la funcion


        if (moneda.getValor() < cualProducto.getPrecio()) {                  //Si se logro sacar una bebida pero el valor de la moneda no alcansa para comprar:
            monVu.add(moneda);                                  //Se agrega la moneda al deposito del vuelto
            producto = null;                                    //Se elimina al producto que se saco del deposito del puntero que la referenciaba
            throw new PagoInsuficienteException("El valor ingresado es menor al precio del producto.");

        } else if (moneda.getValor() > cualProducto.getPrecio()) {                //Si el valor de la moneda ingresada es mayor al precio del producto comprado

            int mon100 = (moneda.getValor() - cualProducto.getPrecio()) / 100;    //Se calcula la diferencia entre el presio y el valor del producto, dividiendolo por 100 para el siguiente for
            for (int i = 0; i < mon100; i++) {                  //For en que se agregan monedas al deposito del vuelto con el valor del vuelto calculado anteriormente
                Moneda vueltomon100 = new Moneda100();          //Se instancia una moneda de 100
                monVu.add(vueltomon100);                        //Se agrega la moneda al deposito del vuelto
            }
        }

        switch (cualProducto) {   //Switch que permite retirar un producto del deposito correspondiente
            case COCACOLA:
                producto = coca.get();    //Se retira una CocaCola del deposito
                break;
            case SPRITE:
                producto = sprite.get();    //Se retira una Sprite del deposito
                break;
            case FANTA:
                producto = fanta.get();   //Se retira una Fanta del deposito
                break;
            case SNICKERS:
                producto = snickers.get();  //Se retira un Snickers del deposito
                break;
            case SUPER8:
                producto = super8.get();    //Se retira un Super8 del deposito
                break;
            default:
                break;
        }

       
        // vaciar el monedero porque no se compro el producto, para devolver la moneda ingresada por el comprador.
        if(producto == null){
            Moneda aux = null;
            do{
               aux = monVu.get();
            } while(aux != null);

            monVu.add(moneda);                
            throw new NoHayProductoException("No hay producto.");
        } 

        return producto;   //Se retorna el producto que se compro o null en otros casos
    }

    /**
     * Funcion que retorna una a una las monedas del deposito del vuelto
     * @return  Moneda del deposito del vuelto
     */
    public Moneda getVuelto() {return monVu.get();}  

    /**
     * Funcion que retorna el valor numerico del precio de los productos
     * @param producto  Producto del que se quiere saber el precio
     * @return  Precio del producto
     */
    public int getPrecio(Precios_Productos producto){
        switch (producto) {
            case COCACOLA:
                return Precios_Productos.COCACOLA.getPrecio();
            case SPRITE:
                return Precios_Productos.SPRITE.getPrecio();
            case FANTA:
                return Precios_Productos.FANTA.getPrecio();
            case SNICKERS:
                return Precios_Productos.SNICKERS.getPrecio();
            case SUPER8:
                return Precios_Productos.SUPER8.getPrecio();
            default:
                return 0;
        }
    }

}