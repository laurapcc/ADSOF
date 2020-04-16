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

    /**
     * Permite registrar un conversor entre unidades de diferentes sistemas metricos
     * Genera automaticamente el conersor inverso al pasado como argumento
     * 
     * @param converter : objeto conversor entre 2 sistemas metricos
     */
    public static void registerConverter(IMetricSystemConverter converter) {
        converters.add(converter);
        converters.add(converter.reverse());
    }

    /**
     * Devuelve el conversor que transforma el sistema metrico actual al sistema que se pasa
     * como arumento. Si no existe devolvera null
     * 
     * @param to sistema metrico destino del conversor
     * @return conversor entre 2 sistemas metricos o null si no existe el conversor especificado
     */
    public IMetricSystemConverter getConverter(IMetricSystem to) {
        for (IMetricSystemConverter converter : converters) {
            if (equals(converter.sourceSystem()) && to.equals(converter.targetSystem()))
                return converter;
        }
        return null;
    }
}