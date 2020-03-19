package ads.practica3;
import java.util.*;

/**
 * Clase Almacen
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Almacen {
    
    private HashMap<Electrodomestico, Integer> stock = new HashMap<Electrodomestico, Integer>();
    private ArrayList<Venta> v = new ArrayList<Venta>();

    /**
     * Añade una nueva venta desde el almacen, en caso de que no se pueda realizar, la anula y la destruye
     * 
     * @param v venta que se quiere hacer desde el almacen
     */
    public void nuevaVenta(Venta v) {
        if (!retirarAlmacen(v.getElecVendido())) {
            System.out.println("Venta: " + v.getElecVendido());
            System.out.println("No se puede realizar la venta puesto que no hay existencias de este producto");
            Venta.anular();
            v = null;
            return;
        }
        this.v.add(v);
    }

    /**
     * Anula la ultima venta del almacen
     */
    public void anularVenta() {
        Venta v = Venta.anular();
        this.v.remove(v);
        
        anadirProducto(v.getElecVendido());
    }

    /**
     * Añade un producto al almacen, sea nuevo o no
     * 
     * @param e Electrodomestico que se desea añadir
     */
    public void anadirProducto(Electrodomestico e) {
        int num;

        if (stock.containsKey(e)) {
            num = stock.get(e);
            stock.replace(e, num+1);
        }
        else
            stock.put(e, 1);
    }

    /**
     * Añade un producto al almacen, sea nuevo o no, indicando el número de los
     * mismos que se desea añadir
     * 
     * @param e Electrodomestico que se desea añadir
     * @param n Numero de unidades que se desea añadir
     */
    public void anadirProducto(Electrodomestico e, int n) {
        int num;

        if (stock.containsKey(e)) {
            num = stock.get(e);
            stock.replace(e, num+n);
        }
        else
            stock.put(e, n);
    }

    /**
     * Retira un producto del almacen
     * 
     * @param e Electrodomestico que se desea retirar
     * @return true si se puede retirar, false en caso contrario
     */
    public boolean retirarAlmacen(Electrodomestico e) {
        int num;

        if (stock.get(e) == null)
            return false;
        else {
            num = stock.get(e);
            if (num == 1)
                stock.remove(e);
            else
                stock.replace(e, num-1);
            return true;
        }
    }

    /**
     * Descataloga un producto, retirando todas sus existencias del
     * almacen
     * 
     * @param e Electrodomestico que se desea descatalogar
     */
    public void descatalogarProducto(Electrodomestico e) {
        stock.remove(e);
    }

    /**
     * Muestra el inventario de las tres clases de electrodomesticos del
     * almacen
     * 
     * @return String con el inventario completo
     */
    public String mostrarInventario() {
        String inventario = "";

        inventario += mostrarInventarioTelevision();
        inventario += mostrarInventarioLavadora();
        inventario += mostrarInventarioFrigorifico();

        return inventario;
    }

    /**
     * Muestra el inventario de las televisiones del almacen
     * 
     * @return String con el inventario de las televisiones
     */
    public String mostrarInventarioTelevision() {
        String inventario = "";

        for (HashMap.Entry<Electrodomestico, Integer> entry : stock.entrySet()) {
            if (entry.getKey() instanceof Television) {
                inventario += "\tElectrodomestico: " + entry.getKey().toString() + "\n" +
                              "\t+ Existencias: " + String.valueOf(entry.getValue()) + "\n";
            }
        }
        if (inventario.equals(""))
            inventario = "\tNo hay existencias de televisiones en el almacen\n";

        return "TELEVISIONES:\n" + inventario;
    }

    /**
     * Muestra el inventario de las lavadoras del almacen
     * 
     * @return String con el inventario de las lavadoras
     */
    public String mostrarInventarioLavadora() {
        String inventario = "";

        for (HashMap.Entry<Electrodomestico, Integer> entry : stock.entrySet()) {
            if (entry.getKey() instanceof Lavadora) {
                inventario += "\tElectrodomestico: " + entry.getKey().toString() + "\n" +
                              "\t+ Existencias: " + String.valueOf(entry.getValue()) + "\n";
            }
        }
        if (inventario.equals(""))
            inventario = "\tNo hay existencias de lavadoras en el almacen\n";

        return "LAVADORAS:\n" + inventario;
    }

    /**
     * Muestra el inventario de los frigorificos del almacen
     * 
     * @return String con el inventario de las lavadoras
     */
    public String mostrarInventarioFrigorifico() {
        String inventario = "";

        for (HashMap.Entry<Electrodomestico, Integer> entry : stock.entrySet()) {
            if (entry.getKey() instanceof Frigorifico) {
                inventario += "\tElectrodomestico: " + entry.getKey().toString() + "\n" +
                              "\t+ Existencias: " + String.valueOf(entry.getValue()) + "\n";
            }
        }
        if (inventario.equals(""))
            inventario = "\tNo hay existencias de frigorificos en el almacen\n";

        return "FRIGORIFICOS:\n" + inventario;
    }
}