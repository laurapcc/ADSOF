package ads.practica3;

/**
 * Clase Television que hereda de Electrodomestico
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Television extends Electrodomestico {

    private double pantalla;

    /**
     * Constructor: crea un objeto de tipo Television con los parametros pasados
     * 
     * @param marca    un String: marca de la television
     * @param modelo   un String: modelo de la television
     * @param precio   un double: precio de la television
     * @param pantalla double: tamano de la pantalla de la television
     */
    public Television(String marca, String modelo, double precio, EficEnergetica claseEnergetica, double pantalla) {
        super(marca, modelo, precio, claseEnergetica);
        this.pantalla = pantalla;
    }

    /**
     * Devuelve el tamano de pantalla de la television
     * 
     * @return pantalla de la television
     */
    public double getPantalla() {
        return this.pantalla;
    }

    /**
     * Actualiza el atributo pantalla de television
     * 
     * @param pantalla double
     */
    public void setPantalla(double pantalla) {
        this.pantalla = pantalla;
    }

    /**
     * Calcula el precio de envio para un electrodomestico de tipo television
     * 
     * @return precio del envio para televisiones
     */
    @Override
    public double precioPorte() {
        if (pantalla <= 40) {
            if (getPrecio() > 500) 
                return 0; 
            else 
                return 35;
        }
        return 35 + pantalla - 40;
    }

}