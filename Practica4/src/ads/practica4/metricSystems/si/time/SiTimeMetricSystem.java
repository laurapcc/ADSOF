package ads.practica4.metricSystems.si.time;

import ads.practica4.metricSystems.si.SiMetricSystem;
import ads.practica4.quantity.Quantity;

/**
 * Clase SiTimeMestricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiTimeMetricSystem extends SiMetricSystem{

    public static final SiTimeMetricSystem MILISECOND = new SiTimeMetricSystem("ms", 0.001);
    public static final SiTimeMetricSystem SECOND = new SiTimeMetricSystem("s", 1);
    public static final SiTimeMetricSystem HOUR = new SiTimeMetricSystem("h", 3600);

    /**
     * Constructor privado de SiTimeMetricSystem
     * 
     * @param abbrev abreviatura de la magnitud de medida
     * @param eqVal valor equivalente de la unidad respecto a la unidad base del sistema
     */
    private SiTimeMetricSystem(String abbrev, double eqVal) {
        super(abbrev, eqVal, Quantity.TIME);
    }

}
