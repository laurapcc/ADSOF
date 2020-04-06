package ads.practica4.metricSystems.si.length;

import ads.practica4.quantity.Quantity;
import ads.practica4.units.IPhysicalUnit;
import ads.practica4.magnitude.exceptions.QuantityException;

/**
 * Enumeracion SiLengthMestricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiLengthMetricSystem implements IPhysicalUnit {

    public static final SiLengthMetricSystem MILIMETER = new SiLengthMetricSystem("mm");
    public static final SiLengthMetricSystem METER = new SiLengthMetricSystem("m");
    public static final SiLengthMetricSystem KILOMETER = new SiLengthMetricSystem("km");

    private final Quantity quantity = Quantity.LENGTH;
    private final String abbrev;

    /**
     * Constructor privado de SiLengthMetricSystem
     * 
     * @param abbrev abreviatura de la magnitud de medida
     */
    private SiLengthMetricSystem(String abbrev) {
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
    private double getEqValue(SiLengthMetricSystem l) {
        double ret = 0;

        if (l.abbrev().equals("mm"))
            ret = 0.001;
        else if (l.abbrev().equals("m"))
            ret = 1;
        else if (l.abbrev().equals("km"))
            ret = 1000;

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
        double val2 = getEqValue((SiLengthMetricSystem)u);

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
    @Override
    public String toString() {
        return abbrev + " " + quantity.toString();
    }
}
