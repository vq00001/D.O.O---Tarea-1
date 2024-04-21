package Clases;

import Clases.Deposito;     //Importacion de la clase Deposito
import Clases.Bebidas.*;    //Importacion de todas las clases Bebida (CocaCola,Sprite,Fanta)
import Clases.Dulces.*;     //Importacion de todas las clases Dulce (Snickers,Super8)
import Clases.Monedas.*;    //Importacion de todas las clases de Moneda (100,500,1000,1500)

public class Expendedor{
    //DECLARACIONES DE ATRIBUTOS     
    private Deposito<Moneda> monVu;     //Deposito que guarda las monedas del vuelto
    private Deposito<Bebida> coca;      //Deposito que guarda las bebidas CocaCola
    private Deposito<Bebida> sprite;    //Deposito que guarda las bebidas Sprite
    private Deposito<Bebida> fanta;     //Deposito que guarda las bebidas Fanta
    private Deposito<Dulce> snickers;   //Deposito que guarda los dulces Snickers
    private Deposito<Dulce> super8;     //Deposito que guarda los dulces Super8


    public enum CONSTANTES{  //Enumeracion que representa los productos que se pueden comprar
        COCACOLA(1),           //Constante que representa a la CocaCola de forma numerica
        SPRITE(2),             //Constante que representa a la Sprite de forma numerica
        FANTA(3),              //Constante que representa a la Fanta de forma numerica
        SNICKERS(4),           //Constante que representa a la Snickers de forma numerica
        SUPER8(5),             //Constante que representa a la Super8 de forma numerica
        PRECIO(1000);          //Constante que representa el precio de los productos de forma numerica

        private final int valor;    //Variable que guarda el valor numerico de la constante

        CONSTANTES(int valor) {this.valor = valor;}  //Constructor de la enumeracion que asigna el valor numerico a la constante

        public int getValor() {return valor;}     //Funcion que retorna el valor numerico de la constante
    };

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
    
    public Producto comprarProducto(Moneda moneda, int cual){   //Funcion que permite comprar productos del expendedor ingresando una moneda y el numero que indica el producto a comprar
        Producto producto = null;                               //Se crea un puntero auxiliar de tipo Bebida nulo
        if (moneda == null) {return null;}                      //Si no se ingreso una moneda se sale de la funcion

        if (cual == CONSTANTES.COCACOLA.getValor()) {producto = coca.get();}           //Si se espesifico una CocaCola, se retira una del deposito
        else if (cual == CONSTANTES.SPRITE.getValor()) {producto = sprite.get();}      //Si se espesifico una Sprite, se retira una del deposito
        else if (cual == CONSTANTES.FANTA.getValor()) {producto = fanta.get();}        //Si se espesifico una Fanta, se retira una del deposito
        else if (cual == CONSTANTES.SNICKERS.getValor()) {producto = snickers.get();}  //Si se espesifico un Snickers, se retira uno del deposito
        else if (cual == CONSTANTES.SUPER8.getValor()) {producto = super8.get();}      //Si se espesifico un Super8, se retira uno del deposito

        if(producto == null){monVu.add(moneda);}                //Si no se saco un productc de algun deposito, se agrega la moneda que se ingreso al deposito del vuelto
        else if (moneda.getValor() < CONSTANTES.PRECIO.getValor()) {                  //Si se logro sacar una bebida pero el valor de la moneda no alcansa para comprar:
            monVu.add(moneda);                                  //Se agrega la moneda al deposito del vuelto
            producto = null;                                    //Se elimina al producto que se saco del deposito del puntero que la referenciaba
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
    
    public int getPrecio(){return CONSTANTES.PRECIO.getValor();}    //Funcion que retorna el valor numerico del precio de los productos
}
