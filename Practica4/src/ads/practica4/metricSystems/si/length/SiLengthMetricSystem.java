package ads.practica4.metricSystems.si.length;

import ads.practica4.metricSystems.si.SiMetricSystem;
import ads.practica4.quantity.Quantity;

/**
 * Clase SiLengthMestricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiLengthMetricSystem extends SiMetricSystem {

    public static final SiLengthMetricSystem MILIMETER = new SiLengthMetricSystem("mm", 0.001);
    public static final SiLengthMetricSystem METER = new SiLengthMetricSystem("m", 1);
    public static final SiLengthMetricSystem KILOMETER = new SiLengthMetricSystem("km", 1000);

    /**
     * Constructor privado de SiLengthMetricSystem
     * 
     * @param abbrev abreviatura de la magnitud de medida
     * @param eqVal valor equivalente de la unidad respecto a la unidad base del sistema
     */
    private SiLengthMetricSystem(String abbrev, double eqVal) {
        super(abbrev, eqVal, Quantity.LENGTH);
    }

}
