import Clases.Monedas.*;    //Importacion de todas las clases de Moneda (100,500,1000,1500)
import Clases.Bebidas.*;    //Importacion de todas las clases Bebida (CocaCola,Sprite)
import Clases.Depositos.*;  //Importacion de todas las clases de Deposito (Deposito,DepositoM)
import Clases.*;            //Importacion de todas las clases del paquete Clases

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
