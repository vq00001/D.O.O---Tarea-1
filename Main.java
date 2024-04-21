import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(7,1000);
        Moneda m = null;
        Comprador c = null;
        m = new Moneda1500();
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+" $"+c.cuantoVuelto());
    }
}

class Comprador{
    //DECLARACIONES DE ATRIBUTOS
    private String sonido;  //Guarda el sonido/gesto de consumir el producto comprado
    private int vuelto = 0; //Guarda el valor numeroco (int) del vuelto resibido al comprar el producto

    //DECLARACIONES DE METODOS
    //Constructor: recibe la moneda con la que comprara, un numero que identifica el tipo de producto y la referencia al Expendedor en el que comprara
    public Comprador(Moneda moneda, int cualBebida, Expendedor exp){
        Bebida b = exp.comprarBebida(moneda,cualBebida);    //Se compra el producto en el expendedor entregandole la moneda y el numero que identifica el tipo de producto
        
        //Bucle en que se asigna el vuelto 
        while (true) {
            Moneda vueltoexp = exp.getVuelto();                 //Se extrae una moneda del deposito de vuelto del expendedor
            if (vueltoexp == null){break;}                      //Si no se extrajo ninguna moneda se sale del bucle, debido a esto vuelto queda en 0 debido a que no se modifico
            vuelto = vuelto + vueltoexp.getValor();             //Si se logro sacar una moneda, el valor de esa moneda se suma con el vuelto guardado en las iteraciones anteriores
            if (b==null) {vuelto = moneda.getValor();break;}    //Si no se logro comprar una bebida se asigna el valor de la moneda que uno ingreso, como que el expendedor la devolviera
        }

        //Gesto de consumir el producto
        if (b == null) {    //Si no se logro conprar un producto
            sonido = null;  //El sonido de consumir el producto queda como null
        }
        else {sonido = b.beber();}  //Si se logro consumir el producto se asigna el gesto/sonido de consumir el producto
    }

    public int cuantoVuelto() {return vuelto;}  //Funcion que retorna el vuelto como un valor "int"
    public String queBebiste() {return sonido;} //Funcion que retorna el sonido de consimir el producto comprado en formato "String"
}

class Expendedor{
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

class Deposito{
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

class DepositoM{
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

abstract class Moneda{
    public Moneda(){}   //Constructor vasio
    public Moneda getSerie(){return this;} //Funsion que retorna la referencia a si mismo
    public abstract int getValor();     //Definision de una funcion para que retorne el valor de la moneda que representa
}

class Moneda1500 extends Moneda{
    public Moneda1500(){super();}           //Constructor vasio
    public int getValor(){return 1500;};    //Funcion que retorna el valor de la moenda que representa
}

class Moneda1000 extends Moneda{
    public Moneda1000(){super();}           //Constructor vasio
    public int getValor(){return 1000;};    //Funcion que retorna el valor de la moenda que representa
}

class Moneda500 extends Moneda{
    public Moneda500(){super();}            //Constructor vasio
    public int getValor(){return 500;};     //Funcion que retorna el valor de la moenda que representa
}

class Moneda100 extends Moneda{
    public Moneda100(){super();}            //Constructor vasio
    public int getValor(){return 100;};     //Funcion que retorna el valor de la moenda que representa
}

abstract class Bebida{
    //DECLARACIONES DE ATRIBUTOS
    private int numSerie;   //Variable que almacena el numero de serie de las bebidas

    //DECLARACIONES DE METODOS
    //Constructor: Asigna el nuemro de serie a la bebida
    public Bebida(int x){numSerie = x;}

    public int getSerie(){return numSerie;} //Funcion que retorna el numero de serie de la bebida
    
    public abstract String beber();         //Declaracion abstracta de la funcion beber, que retornara el sonido/gesto de beberse la bebida
}

class CocaCola extends Bebida{
    public CocaCola(int numSerie){super(numSerie);} //Constructor que utiliza al constructor de su clase Padre Bebida
    public String beber(){return "cocacola";};      //Funcion beber que retorna el sonido/gesto de beberse la bebida
}

class Sprite extends Bebida{
    public Sprite(int numSerie){super(numSerie);}   //Constructor que utiliza al constructor de su clase Padre Bebida
    public String beber(){return "sprite";};        //Funcion beber que retorna el sonido/gesto de beberse la bebida
}
