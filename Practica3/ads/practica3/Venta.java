package ads.practica3;
import java.util.*;

/**
 * Clase Venta
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Venta {

    private Electrodomestico elecVendido;
    private Electrodomestico elecEntregado;
    static private ArrayList<Venta> ventas = new ArrayList<Venta>();

    /**
     * Constructor : crea un nuevo objeto de tipo venta sin entrega de
     * electrodomestico
     * 
     * @param elecVendido electrodomestico del que queremos hacer una nueva venta
     */
    public Venta(Electrodomestico elecVendido) {
        this.elecVendido = elecVendido;
        ventas.add(this);
    }

    /**
     * Constructor : crea un nuevo objeto de tipo venta con entrega de
     * electrodomestico
     * 
     * @param elecVendido   electrodomestico del que queremos hacer una nueva venta
     * @param elecEntregado electrodomestico que entregamos durante la venta
     */
    public Venta(Electrodomestico elecVendido, Electrodomestico elecEntregado) {
        this.elecVendido = elecVendido;
        this.elecEntregado = elecEntregado;
        ventas.add(this);
    }

    /**
     * Obtiene la coleccion de ventas realizadas hasta la fecha
     * 
     * @return coleccion de ventas
     */
    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    /**
     * Obtiene el electrodomestico vendido de la clase venta
     * 
     * @return electrodomestico que queremos obtener
     */
    public Electrodomestico getElecVendido() {
        return this.elecVendido;
    }

    /**
     * Actualiza el atributo electrodomestico vendido de la clase venta
     * 
     * @param elec electrodomestico que queremos actualizar
     */
    public void setElecVendido(Electrodomestico elecVendido) {
        this.elecVendido = elecVendido;
    }

    /**
     * Obtiene el electrodomestico entregado de la clase venta
     * 
     * @return electrodomestico que queremos obtener
     */
    public Electrodomestico getElecEntregado() {
        return this.elecEntregado;
    }

    /**
     * Actualiza el atributo electrodomestico entregado de la clase venta
     * 
     * @param elec electrodomestico que queremos actualizar
     */
    public void setElecEntregado(Electrodomestico elecEntregado) {
        this.elecEntregado = elecEntregado;
    }

    /**
     * Devuelve el importe final a pagar por un electrodomestico
     * 
     * @return importe final tras el descuento
     */
    public double importeFinal() {
        return elecVendido.getPrecio() - descuento(elecEntregado);
    }

    /**
     * Devuelve el descuento que se le hace a un electrodomestico
     * 
     * @param elecEntregado electrodomestico que entregamos y con el que se calcula
     *                      el descuento
     * @return descuento aplicado al electrodomestico vendido
     */
    public double descuento(Electrodomestico elecEntregado) {
        if (elecEntregado == null)
            return 0;
        
        int claseVendido = elecVendido.getClaseEnergetica().ordinal();
        int claseEntregado = elecEntregado.getClaseEnergetica().ordinal();

        if (elecEntregado.getClaseEnergetica() == ClaseEnergetica.Desconocida)
            return 10;
        else if (claseEntregado > claseVendido)
            return 25 + (claseEntregado - claseVendido) * 15;
        else if (claseEntregado < claseVendido)
            return 25 - (claseVendido - claseEntregado) * 5;
        return 25;
    }

    /**
     * Devuelve el ticket de un producto indicando el producto vendido, su precio,
     * el descuento en la entrega y el total a pagar
     * 
     * @return ticket del producto
     */
    public String getTicket() {
        String ticket;

        ticket = "--------------------------------------------\n";
        ticket += getTicketFirstln() + "\n";
        ticket += "--------------------------------------------\n";
        ticket += getTicketSecondln() + "\n";
        ticket += getTicketThirdln() + "\n";
        ticket += getTicketLastln() + "\n";

        return ticket;
    }

    /**
     * Devuelve la primera linea del ticket de un producto
     * 
     * @return primera linea del ticket del producto
     */
    public String getTicketFirstln() {
        return "Producto vendido: " + elecVendido.toString();
    }

    /**
     * Devuelve la segunda linea del ticket de un producto
     * 
     * @return segunda linea del ticket del producto
     */
    public String getTicketSecondln() {
        return "Precio producto:" + String.format("%15.2f Euros", elecVendido.getPrecio());
    }

    /**
     * Devuelve la tercera linea del ticket de un producto
     * 
     * @return tercera linea del ticket del producto
     */
    public String getTicketThirdln() {
        return "Descuento entrega:" + String.format("%13.2f Euros", descuento(elecEntregado));
    }

    /**
     * Devuelve la ultima linea del ticket de un producto
     * 
     * @return ultima linea del ticket del producto
     */
    public String getTicketLastln() {
        return "TOTAL:" + String.format("%25.2f Euros", importeFinal());
    }

    /**
     * Devuelve un String con el total de todas las ventas hechas hasta el momento
     * por orden cronologico
     * 
     * @return total de las ventas realizadas
     */
    public static String resumenVentas() {
        String resumen;

        resumen = "RESUMEN DE VENTAS\n";
        for (Venta v : ventas) {
            resumen += v.getTicketLastln() + "\n";
        }

        return resumen;
    }

    /**
     * Devuelve un String con el total de todas las ventas hechas hasta el momento
     * por orden cronologico cuyo importe final sea mayor o igual al parametro
     * pasado como argumento
     * 
     * @return total de las ventas realizadas con importe no inferior al pasado
     */
    public static String resumenVentas(int param) {
        String resumen;

        resumen = "RESUMEN DE VENTAS\n";
        for (Venta v : ventas) {
            if (v.getElecVendido().getPrecio() - v.descuento(v.getElecEntregado()) < param)
                continue;
            resumen += v.getTicketLastln() + "\n";
        }

        return resumen;
    }

    /**
     * Devuelve un String con el total de todas las ventas hechas hasta el momento
     * por orden cronologico cuya marca contenga el texto pasado como argumento
     * 
     * @return total de las ventas realizadas cuya marca contenga el texto pasado
     */
    public static String resumenVentas(String texto) {
        String resumen;

        resumen = "RESUMEN DE VENTAS\n";
        for (Venta v : ventas) {
            if (v.getElecVendido().getMarca().contains(texto) == false)
                continue;
            resumen += v.getTicketLastln() + "\n";
        }

        return resumen;
    }

    /**
     * Devuelve la ulitma venta de la coleccion
     * 
     * @return ultima venta realizada
     */
    public static Venta ultima() {
        Venta v;
        int size = ventas.size();

        if (size == 0)
            return null;
        v = ventas.get(size-1);

        return v;
    }

    /**
     * Elimina de la coleccion de ventas la ultima almacenada
     * 
     * @return venta anulada de la coleccion
     */
    public static Venta anular() {
        Venta v;
        
        v = ultima();
        ventas.remove(ventas.size()-1);

        return v;
    }
}