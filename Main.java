import Clases.Monedas.*;    //Importacion de todas las clases de Moneda (100,500,1000,1500)
import Clases.Monedas.Moneda1000;
import Clases.*;            //Importacion de todas las clases del paquete Clases (Expendedor,Deposito,Comprador,Producto)

public class Main {
    public static void main(String[] args) {
        Expendedor exp = null;
        Moneda m = null;
        Comprador c = null;

        // Probar con pago insuficiente
        try{
            exp = new Expendedor(3);
            m = new Moneda100();
            c = new Comprador(m,Expendedor.CONSTANTES.SPRITE.getValor(),exp);
            System.out.println(c.queConsumiste()+" $"+c.cuantoVuelto());

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
            exp = new Expendedor(3);
            c = new Comprador(m,Expendedor.CONSTANTES.SPRITE.getValor(),exp);
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
            Comprador c1 = new Comprador(m1, Expendedor.CONSTANTES.SPRITE.getValor(), exp);

            m = new Moneda100();
            c = new Comprador(m,Expendedor.CONSTANTES.SPRITE.getValor(),exp);
            
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
