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
        return getElecEntregado().precioPorte() + importeFinal();
    }

    /**
     * Devuelve el ticket de un producto indicando el producto vendido, su precio, el descuento
     * en la entrega, el coste del porte y el total a pagar
     * 
     * @return ticket del producto
     */
	public String getTicket() {
        String ticket;
        double precioProd = getElecVendido().getPrecio();
        double descEntrega = descuento(getElecEntregado());
        double costePorte = getElecVendido().precioPorte();

        ticket = "--------------------------------------------\n";
        ticket += "Producto vendido: "+getElecVendido().getMarca()+" "+getElecVendido().getModelo()+", "+getElecVendido().getPrecio()+" Euros\n";
        ticket += "--------------------------------------------\n";
        ticket += "Precio producto:"+String.format("%15.2f Euros\n", precioProd);
        ticket += "Descuento entrega:"+String.format("%13.2f Euros\n", descEntrega);
        ticket += "Coste porte:"+String.format("%19.2f Euros\n", costePorte);
        ticket += "TOTAL:"+String.format("%25.2f Euros\n", precioProd-descEntrega+costePorte);

		return ticket;
	}
}