import Clases.*;
import Clases.Monedas.*;
import Clases.Excepciones.*;

/**
 * Clase principal que prueba el funcionamiento de las clases
 * @author Valeria Quiroga
 * @author Antonio Benavides
 */

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(1);
        Moneda m = null;
        Comprador c = null;

        // Probar con pago insuficiente
        try{
            m = new Moneda100();
            c = new Comprador(m,Precios_Productos.SPRITE ,exp);
            System.out.println(c.queConsumiste() + " $"+c.cuantoVuelto());

        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e){
            System.err.println(e.getMessage());
        } 

        // Probar con moneda nula
        try{
            m = null;
            c = new Comprador(m, Precios_Productos.SNICKERS,exp);
            System.out.println(c.queConsumiste()+" $"+c.cuantoVuelto());

        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e){
            System.err.println(e.getMessage());
        }

        // Probar con moneda de igual valor al precio
        try{
            m = new Moneda500();
            c = new Comprador(m, Precios_Productos.SUPER8 ,exp);

            System.out.println(c.queConsumiste()+" $"+c.cuantoVuelto());

        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e){
            System.err.println(e.getMessage());
        }

        // Probar sin producto
        try{
            m = new Moneda1000();
            c = new Comprador(m, Precios_Productos.SNICKERS, exp);

            m = new Moneda1000();
            c = new Comprador(m, Precios_Productos.SNICKERS ,exp);

            System.out.println(c.queConsumiste()+" $"+c.cuantoVuelto());

        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e){
            System.err.println(e.getMessage());
        }


    }
}
