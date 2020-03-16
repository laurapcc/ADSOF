package ads.practica3;

/**
 * Clase VentaCanarias que hereda de VentaDomicilio
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class VentaCanarias extends VentaDomicilio{
    /**
     * Constructor : crea un nuevo objeto de tipo venta a
     * Canarias sin entrega de electrodomestico
     * 
     * @param elecVendido electrodomestico del que queremos hacer
     * una nueva venta
     */
    public VentaCanarias(Electrodomestico elecVendido) {
        super(elecVendido);
    }

    /**
     * Calcula el precio de la entrega a Canarias de un electrodomestico
     * @return precio de la entrega a domicilio
     */
    public double porteCanarias() {
        return getElecVendido().getPrecio() * 0.07;
    }

    /**
     * Calcula el precio total de la compra de un electrodomestico enviado
     * a Canarias
     * @return precio total
     */
    public double entregaDomicilio() {
        return importeFinal() + porteCanarias();
    }
    
    /**
     * Devuelve la cuarta linea del ticket de un producto
     * 
     * @return cuarta linea del ticket del producto
     */
    public String getTicketFourthln() {
        return "Coste porte:" + String.format("%19.2f Euros", porteCanarias());
    }

    
}