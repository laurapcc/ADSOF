/**
 * Clase Electrodomestico
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */

package ads.practica3;

/**
 * Clase Electrodomestico
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Electrodomestico {

    private String marca;
    private String modelo;
    private double precio;

    /**
     * Constructor: crea un objeto de tipo Electrodomestico con los parametros
     * pasados
     * 
     * @param marca  un String: marca del electrodomestico
     * @param modelo un String: modelo del electrodomestico
     * @param precio un double: precio del electrodomestico
     */
    public Electrodomestico(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    /**
     * Devuelve la marca del electrodomestico
     * 
     * @return String: marca del electrodomestico
     */
    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}