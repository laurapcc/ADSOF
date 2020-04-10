package ads.practica4.metricSystems;

import ads.practica4.magnitude.IMagnitude;
import ads.practica4.units.IPhysicalUnit;
import ads.practica4.units.exceptions.UnknownUnitException;

/**
 * Interfaz IMetricSystemConverter
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public interface IMetricSystemConverter {
    IMetricSystem sourceSystem();
    IMetricSystem targetSystem();
    IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException;
    IMetricSystemConverter reverse();
}