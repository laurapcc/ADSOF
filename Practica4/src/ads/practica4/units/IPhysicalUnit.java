package ads.practica4.units;

import ads.practica4.magnitude.exceptions.*;
import ads.practica4.quantity.Quantity;
import ads.practica4.metricSystems.IMetricSystem;


/**
 * Interfaz IPhysicalUnit
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public interface IPhysicalUnit {
    boolean canTransformTo(IPhysicalUnit u);
    double transformTo(double d, IPhysicalUnit u) throws QuantityException;
    Quantity getQuantity();
    String abbrev();
    IMetricSystem getMetricSystem();
}