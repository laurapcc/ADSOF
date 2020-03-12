package ads.practica3;

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

    /**
     * Constructor : crea un nuevo objeto de tipo venta sin
     * entrega de electrodomestico
     * 
     * @param elecVendido electrodomestico del que queremos hacer
     * una nueva venta
     */
    public Venta(Electrodomestico elecVendido) {
        this.elecVendido = elecVendido;
    }

    /**
     * Constructor : crea un nuevo objeto de tipo venta con
     * entrega de electrodomestico
     * 
     * @param elecVendido electrodomestico del que queremos hacer
     * una nueva venta
     * @param elecEntregado electrodomestico que entregamos durante
     * la venta
     */
    public Venta(Electrodomestico elecVendido, Electrodomestico elecEntregado) {
        this.elecVendido = elecVendido;
        this.elecEntregado = elecEntregado;
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
        // EficEnergetica claseVendido;
        // EficEnergetica claseEntregado;
        if (elecEntregado == null)
            return 0;

        int claseVendido = elecVendido.getClaseEnergetica().ordinal();
        int claseEntregado = elecEntregado.getClaseEnergetica().ordinal();

        if (elecEntregado.getClaseEnergetica() == ClaseEnergetica.Desconocida)
            return 10;
        else if (claseEntregado > claseVendido)
            return 25+(claseEntregado-claseVendido)*15;
        else if (claseEntregado < claseVendido)
            return 25-(claseVendido-claseEntregado)*5;
        return 25;
    }

    /**
     * Devuelve el ticket de un producto indicando el producto vendido, su precio, el descuento
     * en la entrega y el total a pagar
     * 
     * @return ticket del producto
     */
	public String getTicket() {
        String ticket;
        double precioProd = elecVendido.getPrecio();
        double descEntrega = descuento(elecEntregado);

        ticket = "--------------------------------------------\n";
        ticket += "Producto vendido: "+elecVendido.getMarca()+" "+elecVendido.getModelo()+", "+elecVendido.getPrecio()+" Euros\n";
        ticket += "--------------------------------------------\n";
        ticket += "Precio producto:"+String.format("%15.2f Euros\n", precioProd);
        ticket += "Descuento entrega:"+String.format("%13.2f Euros\n", descEntrega);
        ticket += "TOTAL:"+String.format("%25.2f Euros\n", precioProd-descEntrega);

		return ticket;
	}
}