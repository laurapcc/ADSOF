package ads.practica4.metricSystems;

import java.util.Collection;

import ads.practica4.units.IPhysicalUnit;

/**
 * Interfaz IMetricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public interface IMetricSystem {
    IPhysicalUnit base();
    Collection<IPhysicalUnit> units();
}