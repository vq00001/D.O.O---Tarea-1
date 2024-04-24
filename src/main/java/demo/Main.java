package demo;
import demo.Clases.*;
import demo.Clases.Excepciones.*;
import demo.Clases.Monedas.*;

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

        } catch (PagoIncorrectoException e){
            System.out.println("No se ha ingresado moneda.");
        } catch(PagoInsuficienteException e){
            System.out.println("El valor ingresado es insuficiente.");
        } catch (NoHayProductoException e){
            System.out.println("No hay producto.");
        }

        System.out.println("---------------------------------");

        // Probar con moneda nula
        try{
            m = null;
            exp = new Expendedor(3);
            c = new Comprador(m, Precios_Productos.SPRITE,exp);
            System.out.println(c.queConsumiste()+" $"+c.cuantoVuelto());

        } catch (PagoIncorrectoException e){
            System.out.println("No se ha ingresado moneda.");
        } catch(PagoInsuficienteException e){
            System.out.println("El valor ingresado es insuficiente.");
        } catch (NoHayProductoException e){
            System.out.println("No hay producto.");
        }

        System.out.println("---------------------------------");

        // Probar sin producto
        try{
            exp = new Expendedor(2);

            Moneda m1 = new Moneda1000();
            Comprador c1 = new Comprador(m1, Precios_Productos.SPRITE, exp);

            m = new Moneda1000();
            c = new Comprador(m, Precios_Productos.SPRITE ,exp);

            System.out.println(c.queConsumiste()+" $"+c.cuantoVuelto());

        } catch (PagoIncorrectoException e){
            System.out.println("No se ha ingresado moneda.");
        } catch(PagoInsuficienteException e){
            System.out.println("El valor ingresado es insuficiente.");
        } catch (NoHayProductoException e){
            System.out.println("No hay producto.");
        }

    }
}
