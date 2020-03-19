package ads.practica3;

/**
 * Clase TelevisionCurva que hereda de Television
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class TelevisionCurva extends Television {

    private Dimension dim;
    private double peso;

    /**
     * Constructor: crea un objeto de tipo TelevisionCurva con los parametros pasados
     * 
     * @param marca    un String: marca de la television
     * @param modelo   un String: modelo de la television
     * @param precio   un double: precio de la television
     * @param pantalla double: tamano de la pantalla de la television
     * @param dim      dim: dimensiones de la television
     * @param peso     double: peso de la television
     */
    public TelevisionCurva(String marca, String modelo, double precio, ClaseEnergetica claseEnergetica,
                         double pantalla, Dimension dim, double peso) {
        super(marca, modelo, precio, claseEnergetica, pantalla);
        this.dim = dim;
        this.peso = peso;
    }

    /**
     * Devuelve las dimensiones de la television
     * 
     * @return obejto Dimension
     */
    public Dimension getDim() {
        return this.dim;
    }

    /**
     * Actualiza el atributo dim de la television
     * 
     * @param dim objeto Dimension
     */
    public void setDim(Dimension dim) {
        this.dim = dim;
    }
    
    /**
     * Devuelve el peso de la television
     * 
     * @return peso
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Actualiza el atributo peso de la television
     * 
     * @param peso double
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Calcula el precio de envio para una television
     * 
     * @return precio del envio para televisiones
     */
    @Override
    public double precioPorte() {
        double metros3 = dim.volumen() * Math.pow(10,-6);
        return super.precioPorte() + Math.ceil(metros3);
    }

}