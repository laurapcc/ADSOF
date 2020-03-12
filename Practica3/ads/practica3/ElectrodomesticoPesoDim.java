package ads.practica3;

/**
 * Clase ElectrodomesticoPesoDim que hereda de Electrodomestico
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public abstract class ElectrodomesticoPesoDim extends Electrodomestico {

    private double peso;
    private Dimension dim;

    /**
     * Constructor: crea un objeto de tipo ElectrodomesticoPesoDim 
     * con los parametros pasados
     * 
     * @param marca String: marca del electrodomestico
     * @param modelo String: modelo del electrodomestico
     * @param precio double: precio del electrodomestico
     * @param dim Dimension: dimensiones del electrodomestico
     * @param peso double: peso de la electrodomestico
     */
    public ElectrodomesticoPesoDim(String marca, String modelo, double precio,
                                 ClaseEnergetica claseEnergetica, Dimension dim,
                                 double peso) {
        super(marca, modelo, precio, claseEnergetica);
        this.dim = dim;
        this.peso = peso;
    }

    /**
     * Devuelve las dimensiones del electrodomestico
     * 
     * @return obejto Dimension
     */
    public Dimension getDim() {
        return this.dim;
    }

    /**
     * Actualiza el atributo dim del electrodomestico
     * 
     * @param dim objeto Dimension
     */
    public void setDim(Dimension dim) {
        this.dim = dim;
    }
    
    /**
     * Devuelve el peso del electrodomestico
     * 
     * @return peso
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Actualiza el atributo peso del electrodomestico
     * 
     * @param peso double
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

}