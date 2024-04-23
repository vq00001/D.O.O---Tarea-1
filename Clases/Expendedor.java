package Clases;

import Clases.*;            //Importacion de las clases del paquete Clases (Deposito,Producto,Moneda)
import Clases.Bebidas.*;    //Importacion de todas las clases Bebida (CocaCola,Sprite,Fanta)
import Clases.Dulces.*;     //Importacion de todas las clases Dulce (Snickers,Super8)
import Clases.Monedas.*;    //Importacion de todas las clases de Moneda (100,500,1000,1500)
import Clases.PagoIncorrectoException;    //Importacion de excepcion
import Clases.PagoInsuficienteException;    //Importacion de excepcion
import Clases.NoHayProductoException;    //Importacion de excepcion

public class Expendedor{
    //DECLARACIONES DE ATRIBUTOS     
    private Deposito<Moneda> monVu;     //Deposito que guarda las monedas del vuelto
    private Deposito<Bebida> coca;      //Deposito que guarda las bebidas CocaCola
    private Deposito<Bebida> sprite;    //Deposito que guarda las bebidas Sprite
    private Deposito<Bebida> fanta;     //Deposito que guarda las bebidas Fanta
    private Deposito<Dulce> snickers;   //Deposito que guarda los dulces Snickers
    private Deposito<Dulce> super8;     //Deposito que guarda los dulces Super8

    //DECLARACIONES DE METODOS
    //Contructor: Recibe la cantidad de bebidas con la que se llenaran los depositos y el presio de estas
    public Expendedor(int numBebidas)
    {
        monVu = new Deposito<Moneda>();     //Instanciacion del Deposito de Monedas
        coca = new Deposito<Bebida>();      //Instanciacion del Deposito de CocaColas
        sprite = new Deposito<Bebida>();    //Instanciacion del Deposito de Sprite
        fanta = new Deposito<Bebida>();     //Instanciacion del Deposito de Fanta
        snickers = new Deposito<Dulce>();   //Instanciacion del Deposito de Snickers
        super8 = new Deposito<Dulce>();     //Instanciacion del Deposito de Super8
        
        for (int i = 0; i < numBebidas; i++) {      //For en que se rellenan los depositos con sus respectivasd monedas
            Bebida bc = new CocaCola(i);            //Se crea una CocaCola con su numero de serie
            coca.add(bc);                     //Se ingresa la bebida recien creada al deposito de CocaCola
            Bebida bs = new Sprite(numBebidas+i);   //Se crea una Sprite con su numero de serie
            sprite.add(bs);                   //Se ingresa la bebida recien creada al deposito de Sprite
            Bebida bf = new Fanta(2*numBebidas+i);   //Se crea una Fanta con su numero de serie
            fanta.add(bf);                   //Se ingresa la bebida recien creada al deposito de Fanta
            Dulce ds = new Snickers(3*numBebidas+i);            //Se crea un Snickers con su numero de serie
            snickers.add(ds);                 //Se ingresa el dulce recien creado al deposito de Snickers
            Dulce d8 = new Super8(4*numBebidas+i);   //Se crea un Super8 con su numero de serie
            super8.add(d8);                   //Se ingresa el dulce recien creado al deposito de Super8
        }
    }
    

    public Producto comprarProducto(Moneda moneda, int cual) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{   //Funcion que permite comprar productos del expendedor ingresando una moneda y el numero que indica el producto a comprar

        Producto producto = null;                               //Se crea un puntero auxiliar de tipo Bebida nulo

        if (moneda == null) {throw new PagoIncorrectoException("No se ingreso moneda.");}  //Si no se ingreso una moneda se sale de la funcion

        switch (cual) {   //Switch que permite retirar un producto del deposito correspondiente
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

        if(producto == null){
            monVu.add(moneda);                //Si no se saco un productc de algun deposito, se agrega la moneda que se ingreso al deposito del vuelto
            throw new NoHayProductoException("No hay producto.");
        }
        else if (moneda.getValor() < CONSTANTES.PRECIO.getValor()) {                  //Si se logro sacar una bebida pero el valor de la moneda no alcansa para comprar:
            monVu.add(moneda);                                  //Se agrega la moneda al deposito del vuelto
            producto = null;                                    //Se elimina al producto que se saco del deposito del puntero que la referenciaba
            throw new PagoInsuficienteException("El valor ingresado es menor al precio del producto.");
            
        } else if (moneda.getValor() > CONSTANTES.PRECIO.getValor()) {                //Si el valor de la moneda ingresada es mayor al precio del producto comprado
            int mon100 = (moneda.getValor() - CONSTANTES.PRECIO.getValor()) / 100;    //Se calcula la diferencia entre el presio y el valor del producto, dividiendolo por 100 para el siguiente for
            for (int i = 0; i < mon100; i++) {                  //For en que se agregan monedas al deposito del vuelto con el valor del vuelto calculado anteriormente
                Moneda vueltomon100 = new Moneda100();          //Se instancia una moneda de 100
                monVu.add(vueltomon100);                        //Se agrega la moneda al deposito del vuelto
            }
        }
      
        return producto;   //Se retorna el producto que se compro o null en otros casos
    }
    
    public Moneda getVuelto() {return monVu.get();}   //Funcion que retorna una a una las monedas del deposito del vuelto
    
    public int getPrecio(Precios_Productos producto){                             //Funcion que retorna el valor numerico del precio de los productos
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
