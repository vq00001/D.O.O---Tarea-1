package Clases;

import Clases.Depositos.*;  //Importacion de todas las clases de Deposito (Deposito,DepositoM)
import Clases.Bebidas.*;    //Importacion de todas las clases Bebida (CocaCola,Sprite)
import Clases.Monedas.*;    //Importacion de todas las clases de Moneda (100,500,1000,1500)

public class Expendedor{
    //DECLARACIONES DE ATRIBUTOS
    public static final int  COCA=1;    //Constante que representa a la CocaCola de forma numerica
    public static final int  SPRITE=2;  //Constante que representa a la Sprite de forma numerica
    private DepositoM monVu;    //Deposito que guarda las monedas del vuelto
    private Deposito coca;      //Deposito que guarda las bebidas CocaCola
    private Deposito sprite;    //Deposito que guarda las bebidas Sprite
    private int precio;         //Variable que guarda el presio de los productos

    //DECLARACIONES DE METODOS
    //Contructor: Recibe la cantidad de bebidas con la que se llenaran los depositos y el presio de estas
    public Expendedor(int numBebidas, int precioBebidas)
    {
        precio = precioBebidas;     //Se registra el precio de los productos en la variable interna del expendedor
        monVu = new DepositoM();    //Instanciacion del Deposito de Monedas
        coca = new Deposito();      //Instanciacion del Deposito de CocaColas
        sprite = new Deposito();    //Instanciacion del Deposito de Sprite
        
        for (int i = 0; i < numBebidas; i++) {      //For en que se rellenan los depositos con sus respectivasd monedas
            Bebida bc = new CocaCola(i);            //Se crea una CocaCola con su numero de serie
            coca.addBebida(bc);                     //Se ingresa la bebida resien creada al deposito de CocaCola
            Bebida bs = new Sprite(numBebidas+i);   //Se crea una Sprite con su numero de serie
            sprite.addBebida(bs);                   //Se ingresa la bebida resien creada al deposito de Sprite
        }
    }
    
    public Bebida comprarBebida(Moneda moneda, int cual){ //Funcion que permite comprar productos del expendedor ingresando una moneda y el numero que indica el producto a comprar
        Bebida b = null;                                        //Se crea un puntero auxiliar de tipo Bebida nulo
        if (moneda == null) {return null;}                      //Si no se ingreso una moneda se sale de la funcion
        if (cual == COCA) {b = coca.getBebida();}               //Si se espesifico una CocaCola, se retira una del deposito
        else if (cual == SPRITE) {b = sprite.getBebida();}      //Si se espesifico una Sprite, se retira una del deposito
        if(b == null){monVu.addMoneda(moneda);}                 //Si no se saco una bebida de algun deposito, se agrega la moneda que se ingreso al deposito del vuelto
        else if (moneda.getValor() < precio) {                  //Si se logro sacar una bebida pero el valor de la moneda no alcansa para comprar:
            monVu.addMoneda(moneda);                            //Se agrega la moneda al deposito del vuelto
            b = null;                                           //Se elimina la bebida que se saco del deposito del puntero que la referenciaba
        } else if (moneda.getValor() > precio) {                //Si el valor de la moenda ingresada es mayor al precio del producto comprado
            int mon100 = (moneda.getValor() - precio) / 100;    //Se calcula la diferencia entre el presio y el valor del producto, dividiendolo por 100 para el siguiente for
            for (int i = 0; i < mon100; i++) {                  //For en que se agregan monedas al deposito del vuelto con el valor del vuelto calculado anteriormente
                Moneda vueltomon100 = new Moneda100();          //Se instancia una moneda de 100
                monVu.addMoneda(vueltomon100);                  //Se agrega la moneda al deposito del vuelto
            }
        }
        return b;   //Se retorna la bebida que se compro o null en otros casos
    }
    
    public Moneda getVuelto() {return monVu.getMoneda();}   //Funcion que retorna una a una las monedas del deposito del vuelto
    
    public int getPrecio(){return precio;}                  //Funcion que retorna el valor numerico del repcio de los productos
}
