package ads.practica4.magnitude;

import ads.practica4.units.IPhysicalUnit;
import ads.practica4.magnitude.exceptions.*;

/**
 * Interfaz IMagnitude
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public interface IMagnitude {
    IMagnitude add(IMagnitude m) throws QuantityException;
    IMagnitude subs(IMagnitude m) throws QuantityException;
    IMagnitude transformTo(IPhysicalUnit c) throws QuantityException;
    IPhysicalUnit getUnit();
    double getValue();
}