package ads.practica4.metricSystems.imperial.length;

import ads.practica4.metricSystems.si.SiMetricSystem;
import ads.practica4.quantity.Quantity;

/**
 * Clase ImperialLengthMestricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class ImperialLengthMetricSystem extends SiMetricSystem {

    public static final ImperialLengthMetricSystem INCH = new ImperialLengthMetricSystem("in", 1/12);
    public static final ImperialLengthMetricSystem FOOT = new ImperialLengthMetricSystem("ft", 1);
    public static final ImperialLengthMetricSystem MILE = new ImperialLengthMetricSystem("mi", 5280);

    /**
     * Constructor privado de ImperialLengthMetricSystem
     * 
     * @param abbrev abreviatura de la magnitud de medida
     * @param eqVal valor equivalente de la unidad respecto a la unidad base del sistema
     */
    private ImperialLengthMetricSystem(String abbrev, double eqVal) {
        super(abbrev, eqVal, Quantity.LENGTH);
    }

}
