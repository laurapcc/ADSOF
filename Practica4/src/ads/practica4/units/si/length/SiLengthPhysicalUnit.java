package ads.practica4.units.si.length;

import ads.practica4.quantity.Quantity;
import ads.practica4.units.PhysicalUnit;

/**
 * Clase SiLengthPhysicalUnit
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiLengthPhysicalUnit extends PhysicalUnit{

    /**
     * Constructor de SiLengthPhysicalUnit
     * 
     * @param abbrev abreviatura de la magnitud de medida
     * @param eqVal valor equivalente de la unidad respecto a la unidad base del sistema
     */
    public SiLengthPhysicalUnit(String abbrev, double eqVal) {
        super(abbrev, eqVal, Quantity.LENGTH);
    }
}
