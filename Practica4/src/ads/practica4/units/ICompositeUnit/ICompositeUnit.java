package ads.practica4.units.ICompositeUnit;

import ads.practica4.units.IPhysicalUnit;

/**
 * Interfaz ICompositeUnit
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public interface ICompositeUnit extends IPhysicalUnit {
    Operator getOperator();
    IPhysicalUnit getLeftUnit();
    IPhysicalUnit getRightUnit();
}