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
        return getElecEntregado().precioPorte() + importefinal();
    }

    /**
     * 
     * @return
     */
    private double importefinal() {
        return 0;
    }
}