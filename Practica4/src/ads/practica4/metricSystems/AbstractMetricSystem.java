package ads.practica4.metricSystems;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase abstracta AbstractMetricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public abstract class AbstractMetricSystem implements IMetricSystem {

    public static Set<IMetricSystemConverter> converters = new HashSet<IMetricSystemConverter>();

    public static void registerConverter(IMetricSystemConverter converter) {
        converters.add(converter);
        converters.add(converter.reverse());
    }

    public IMetricSystemConverter getConverter(IMetricSystem to) {
        for (IMetricSystemConverter converter : converters) {
            if (equals(converter.sourceSystem()) && to.equals(converter.targetSystem()))
                return converter;
        }
        return null;
    }
}