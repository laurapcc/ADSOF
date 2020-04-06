package ads.practica4.metricSystems.si.time;

import ads.practica4.quantity.Quantity;
import ads.practica4.units.IPhysicalUnit;
import ads.practica4.magnitude.exceptions.QuantityException;

/**
 * Enumeracion SiTimeMestricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiTimeMetricSystem implements IPhysicalUnit{

    public static final SiTimeMetricSystem MILISECOND = new SiTimeMetricSystem("ms");
    public static final SiTimeMetricSystem SECOND = new SiTimeMetricSystem("s");
    public static final SiTimeMetricSystem HOUR = new SiTimeMetricSystem("h");

    private final Quantity quantity = Quantity.TIME;
    private final String abbrev;

    /**
     * Constructor privado de SiTimeMetricSystem
     * 
     * @param abbrev abreviatura de la magnitud de medida
     */
    private SiTimeMetricSystem(String abbrev) {
        this.abbrev = abbrev;
    }

    /**
     * Comprueba si se puede transormar la magnitud actual a la que es pasada
     * como argumento
     * 
     * @param u : unidad de medida que queremos comprobar
     * @return : true si se puede transomar, false en caso contrario
     */
    public boolean canTransformTo(IPhysicalUnit u) {
        return quantity.equals(u.getQuantity());
    }

    /**
     * Metodo privado que calcula el valor equivalente de una unidad fisica. El valor
     * equivalente es el numero de unidades basicas que hay en la unidad fisica que
     * se pasa como argumento
     * 
     * @param l unidad fisica de la cual queremos sabel el valor equivalente
     * @return valor equivalente
     */
    private double getEqValue(SiTimeMetricSystem t) {
        double ret = 0;

        if (t.abbrev().equals("ms"))
            ret = 0.001;
        else if (t.abbrev().equals("s"))
            ret = 1;
        else if (t.abbrev().equals("h"))
            ret = 3600;

        return ret;
    }

    /**
     * Transforma la unidad d de la magnitud actual a la pasada como argumento
     * 
     * @param d : cantidad que queremos cambiar de magnitud
     * @param u : unidad de medida a la cual queremos transformar
     * @return : resultado de la transformacion
     */
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        double val1 = getEqValue(this);
        double val2 = getEqValue((SiTimeMetricSystem)u);
        
        return d*(val1/val2);
    }

    /**
     * Devuelve el quantity de la magnitud
     * 
     * @return : quantity de la magnitud actual
     */
    public Quantity getQuantity() {
        return this.quantity;
    }

    /**
     * Devuelve la abreviatura de la magnitud
     * 
     * @return : atributo abbrev de la magnitud
     */
    public String abbrev() {
        return this.abbrev;
    }

    /**
     * Devuelve el String formado por la abreviatura de la magnitud y su
     * quantity
     * 
     * @return : String formado por abbrev y quantity
     */
    public String toString() {
        return abbrev + " " + quantity;
    }
}
