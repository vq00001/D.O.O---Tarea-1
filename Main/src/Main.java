import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        
    
        Expendedor exp = new Expendedor(2,1000);
        Moneda m = null;
        Comprador c = null;

        System.out.println("-------------------------------------");
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+" $"+c.cuantoVuelto());
        
        System.out.println("-------------------------------------");
        m = new Moneda100();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+" $"+c.cuantoVuelto());
       
        System.out.println("-------------------------------------");
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+" $"+c.cuantoVuelto());
        
        System.out.println("-------------------------------------");
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+" $"+c.cuantoVuelto());
        

    }
}



// PagoIncorrectoException, NoHayProductoException y PagoInsuficienteException
class PagoIncorrectoException extends Exception
{
    public PagoIncorrectoException (String message){
        super(message);
    }
}

class PagoInsuficienteException extends Exception
{
    public PagoInsuficienteException (String message){
        super(message);
    }
}

class NoHayProductoException extends Exception
{
    public NoHayProductoException (String message){
        super(message);
    }
}

class Comprador
{
    private String sonido;
    private int vuelto = 0;
    private boolean compro;
    public Comprador(Moneda m, int cualBebida, Expendedor exp){

        Bebida b = null;

        try{
            b = exp.comprarBebida(m,cualBebida);

        } catch(PagoIncorrectoException e) {
            System.out.println("Moneda no ingresada");
        } catch(PagoInsuficienteException e){
            System.out.println("Pago insuficiente");
        } catch(NoHayProductoException e){
            System.out.println("No hay producto.");
        }

        while (true) {
            Moneda vueltoexp = exp.getVuelto();
            if (vueltoexp == null){break;}
            vuelto = vuelto + vueltoexp.getValor();
            if (b==null) {vuelto = m.getValor();break;}
        }
        if (b == null) {
            sonido = null;
        }
        else {sonido = b.beber();}
    }
    public int cuantoVuelto() {return vuelto;}
    public String queBebiste() {return sonido;}
}
class Expendedor
{
    public static final int  COCA=1;
    public static final int  SPRITE=2;
    private DepositoM monVu;
    private Deposito coca;
    private Deposito sprite;
    private int precio;
    public Expendedor(int numBebidas, int precioBebidas)
    {
        precio = precioBebidas;
        monVu = new DepositoM();
        coca = new Deposito();
        sprite = new Deposito();
        for (int i = 0; i < numBebidas; i++) {
            Bebida bc = new CocaCola(i);
            coca.addBebida(bc);
            Bebida bs = new Sprite(numBebidas+i);
            sprite.addBebida(bs);
        }
    }
    public Bebida comprarBebida (Moneda m, int cual) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{  // cambiar a comprar producto
    
        Bebida b = null;

        if (m == null) {
            throw new PagoIncorrectoException("No se ingreso moneda.");
            // return null;
        }

        if (cual == 1) {b = coca.getBebida();}

        else if (cual == 2) {b = sprite.getBebida();}

        if(b == null){
            monVu.addMoneda(m);
            throw new NoHayProductoException("No quedan bebidas");

        } else if (m.getValor() < precio) {
            
            // al pedir una bebida con las monedas insuficientes igualmente se le descuenta la bebida al expendedor, lo que es un problema
            monVu.addMoneda(m);
            b = null;
            throw new PagoInsuficienteException("Pago Insuficiente.");

        } else if (m.getValor() >= precio) {

            int mon100 = (m.getValor() - precio) / 100;
            for (int i = 0; i < mon100; i++) {
                Moneda vueltomon100 = new Moneda100();
                monVu.addMoneda(vueltomon100);
            }
        }

        return b;
    }

    public Moneda getVuelto() {return monVu.getMoneda();}
    public int getPrecio(){return precio;}
}
class Deposito
{
    ArrayList<Bebida> a;
    public Deposito() {a = new ArrayList<Bebida>();}
    public void addBebida(Bebida x) {a.add(x);}
    public Bebida getBebida()
    {
        if (a.size() != 0) {return a.remove(0);}
        else return null;
    }
}
class DepositoM
{
    ArrayList<Moneda> a;
    public DepositoM()
    {
        a = new ArrayList<Moneda>();
    }
    public void addMoneda(Moneda x){a.add(x);}
    public Moneda getMoneda()
    {
        if (a.size() > 0) {return a.remove(0);}
        else return null;
    }
}
abstract class Moneda
{
    public Moneda(){}
    public Moneda getSerie()
    {return this;}
    public abstract int getValor();
}
class Moneda1500 extends Moneda
{
    public Moneda1500()
    {super();}
    public int getValor(){return 1500;};
}
class Moneda1000 extends Moneda
{
    public Moneda1000()
    {super();}
    public int getValor(){return 1000;};
}
class Moneda500 extends Moneda
{
    public Moneda500()
    {super();}
    public int getValor(){return 500;};
}
class Moneda100 extends Moneda
{
    public Moneda100()
    {super();}
    public int getValor(){return 100;};
}
abstract class Bebida
{
    private int numSerie;
    public Bebida(int x)
    {
        numSerie = x;
    }
    public int getSerie(){return numSerie;}
    public abstract String beber();
}
class CocaCola extends Bebida
{
    public CocaCola(int numSerie)
    {super(numSerie);}
    public String beber(){return "cocacola";};
}
class Sprite extends Bebida
{
    public Sprite(int numSerie)
    {super(numSerie);}
    public String beber(){return "sprite";};
}


