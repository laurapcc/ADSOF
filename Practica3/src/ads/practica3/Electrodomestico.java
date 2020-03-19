package ads.practica3;

/**
 * Clase Electrodomestico
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public abstract class Electrodomestico {

    private String marca;
    private String modelo;
    private double precio;
    private ClaseEnergetica claseEnergetica;

    /**
     * Constructor: crea un objeto de tipo Electrodomestico con los parametros
     * pasados
     * 
     * @param marca  un String: marca del electrodomestico
     * @param modelo un String: modelo del electrodomestico
     * @param precio un double: precio del electrodomestico
     */
    public Electrodomestico(final String marca, final String modelo, final double precio, final ClaseEnergetica claseEnergetica) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.claseEnergetica = claseEnergetica;
    }

    /**
     * Devuelve la marca del electrodomestico
     * 
     * @return String: marca del electrodomestico
     */
    public String getMarca() {
        return this.marca;
    }

    /**
	 * Actualiza el atributo marca de electrodomestico
	 * 
	 * @param marca String
	 */
    public void setMarca(final String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve el modelo del electrodomestico
     * 
     * @return String: modelo del electrodomestico
     */
    public String getModelo() {
        return this.modelo;
    }

    /**
	 * Actualiza el atributo modelo de electrodomestico
	 * 
	 * @param modelo String
	 */
    public void setModelo(final String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve la marca del electrodomestico
     * 
     * @return String: marca del electrodomestico
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
	 * Actualiza el atributo precio de electrodomestico
	 * 
	 * @param precio double
	 */
    public void setPrecio(final double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve la clase energetica del electrodomestico
     * 
     * @return ClaseEnergetica: clase energetica
     */
    public ClaseEnergetica getClaseEnergetica() {
        return this.claseEnergetica;
    }

    /**
	 * Actualiza el atributo claseEnergetica de electrodomestico
	 * 
	 * @param claseEnergetica elemento de la enumeracion ClaseEnergetica
	 */
    public void setClaseEnergetica(final ClaseEnergetica claseEnergetica) {
        this.claseEnergetica = claseEnergetica;
    }

    /**
     * Calcula el precio de envio dependiendo del tipo de electrodomestico
     * 
     * @return double: precio del envio
     */
    public abstract double precioPorte();
    
    /**
     * Metodo toString genérico de la clase Electrodomestico
     * 
     * @return String con la marca, modelo y precio del Electrodomestico
     */
    @Override
    public String toString() {
        return getMarca() + " " + getModelo() + String.format(", %.2f Euros", getPrecio());
    }

    /**
     * Compara si dos objectos de la clase Electrodomestico son iguales
     * 
     * @return true si son el mismo tipo de Electrdomestico, tienen la misma marca y modelo.
     * Devuelve false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        if (!((Electrodomestico)obj).getMarca().equals(marca))
            return false;
        if (!((Electrodomestico)obj).getModelo().equals(modelo))
            return false;
        return true;
    }
}