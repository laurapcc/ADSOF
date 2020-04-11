package ads.practica4.metricSystems.si.length.converters;

import ads.practica4.metricSystems.AbstractMetricSystemConverter;
import ads.practica4.metricSystems.imperial.length.ImperialLengthMetricSystem;
import ads.practica4.metricSystems.si.length.SiLengthMetricSystem;

/**
 * Clase SiLength2ImperialConverter
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiLength2ImperialConverter extends AbstractMetricSystemConverter {

    /**
     * Constructor de SiLenght2ImperialConverter
     */
    public SiLength2ImperialConverter() {
        super(SiLengthMetricSystem.SYSTEM, ImperialLengthMetricSystem.SYSTEM, 3.280839895);
    }
}