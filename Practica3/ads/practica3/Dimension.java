package ads.practica3;

/**
 * Clase Dimension (cm)
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Dimension {

    private double alto;
    private double ancho;
    private double largo;

    /**
     * Constructor: crea un objeto de tipo Dimension con los parametros pasados
     * 
     * @param alto
     * @param ancho
     * @param largo
     */
    public Dimension(double ancho, double largo, double alto) {
        this.ancho = ancho;
        this.largo = largo;
        this.alto = alto;
    }

    /**
     * Devuelve el alto el objeto dimension
     * 
     * @return alto
     */
    public double getAlto() {
        return this.alto;
    }

    /**
     * Actualiza el atributo alto de Dimension
     * 
     * @param alto
     */
    public void setAlto(double alto) {
        this.alto = alto;
    }

    /**
     * Devuelve el ancho el objeto dimension
     * 
     * @return ancho
     */
    public double getAncho() {
        return this.ancho;
    }

    /**
     * Actualiza el atributo ancho de Dimension
     * 
     * @param ancho
     */
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    /**
     * Devuelve el largo el objeto dimension
     * 
     * @return largo
     */
    public double getLargo() {
        return this.largo;
    }

    /**
     * Actualiza el atributo largo de Dimension
     * 
     * @param largo
     */
    public void setLargo(double largo) {
        this.largo = largo;
    }
    
    /**
     * Calcula el volumen de un objeto dimension
     * 
     * @return volumen
     */
    public double volumen(){
        return alto*ancho*largo;
    }
}