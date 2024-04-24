import Clases.*;
import Clases.Monedas.*;
import Clases.Excepciones.*;

/**
 * Clase principal que prueba el funcionamiento de las clases
 * @autor Valeria Quiroga
 * @autor Antonio Benavides
 */

public class Main {
    public static void main(String[] args) {
        Expendedor exp = null;
        Moneda m = null;
        Comprador c = null;

        // Probar con pago insuficiente
        try{
            exp = new Expendedor(3);
            m = new Moneda100();
            c = new Comprador(m,Precios_Productos.SPRITE ,exp);
            System.out.println(c.queConsumiste() + " $"+c.cuantoVuelto());

        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e){
            System.err.println(e.getMessage());
        } 

        System.out.println("---------------------------------");

        // Probar con moneda nula
        try{
            m = null;
            exp = new Expendedor(3);
            c = new Comprador(m, Precios_Productos.SNICKERS,exp);
            System.out.println(c.queConsumiste()+" $"+c.cuantoVuelto());

        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e){
            System.err.println(e.getMessage());
        } 

        System.out.println("---------------------------------");

        // Probar sin producto
        try{
            exp = new Expendedor(2);

            Moneda m1 = new Moneda1000();
            Comprador c1 = new Comprador(m1, Precios_Productos.SNICKERS, exp);

            m = new Moneda1000();
            c = new Comprador(m, Precios_Productos.SNICKERS ,exp);

            System.out.println(c.queConsumiste()+" $"+c.cuantoVuelto());

        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e){
            System.err.println(e.getMessage());
        } 

        System.out.println("---------------------------------");

        // Probar con moneda de igual valor al precio
        try{
            exp = new Expendedor(2);
            m = new Moneda500();
            c = new Comprador(m, Precios_Productos.SUPER8 ,exp);

            System.out.println(c.queConsumiste()+" $"+c.cuantoVuelto());

        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e){
            System.err.println(e.getMessage());
        }
    }
}
