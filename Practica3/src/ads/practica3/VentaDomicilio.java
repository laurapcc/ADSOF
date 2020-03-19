package ads.practica3;

/**
 * Clase VentaDomicilio que hereda de Venta
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class VentaDomicilio extends Venta {

    /**
     * Constructor : crea un nuevo objeto de tipo venta a
     * domicilio sin entrega de electrodomestico
     * 
     * @param elecVendido electrodomestico del que queremos hacer
     * una nueva venta
     */
    public VentaDomicilio(Electrodomestico elecVendido) {
        super(elecVendido);
    }

    /**
     * Constructor : crea un nuevo objeto de tipo venta a
     * domiclio con entrega de electrodomestico
     * 
     * @param elecVendido electrodomestico del que queremos hacer
     * una nueva venta
     * @param elecEntregado electrodomestico que entregamos durante
     * la venta
     */
    public VentaDomicilio(Electrodomestico elecVendido, Electrodomestico elecEntregado) {
        super(elecVendido, elecEntregado);
    }

    /**
     * Calcula el precio de la entrega a domicilio de un electrodomestico
     * @return precio de la entrega a domicilio
     */
    public double entregaDomicilio() {
        return getElecVendido().precioPorte() + importeFinal();
    }
    
    /**
     * Devuelve el ticket de un producto indicando el producto vendido, su precio,
     * el descuento en la entrega y el total a pagar
     * 
     * @return ticket del producto
     */
    @Override
    public String getTicket() {
        String ticket;

        ticket = "--------------------------------------------\n";
        ticket += getTicketFirstln() + "\n";
        ticket += "--------------------------------------------\n";
        ticket += getTicketSecondln() + "\n";
        ticket += getTicketThirdln() + "\n";
        ticket += getTicketFourthln() + "\n";
        ticket += getTicketLastln() + "\n";

        return ticket;
    }

    /**
     * Devuelve la cuarta linea del ticket de un producto
     * 
     * @return cuarta linea del ticket del producto
     */
    public String getTicketFourthln() {
        return "Coste porte:" + String.format("%19.2f Euros", getElecVendido().precioPorte());
    }

    /**
     * Devuelve la ultima linea del ticket de un producto
     * 
     * @return ultima linea del ticket del producto
     */
    @Override
    public String getTicketLastln() {
        return "TOTAL:" + String.format("%25.2f Euros", entregaDomicilio());
    }
}