package ads.practica4.units.imperial.length;

import ads.practica4.quantity.Quantity;
import ads.practica4.units.PhysicalUnit;

/**
 * Clase ImperialLengthPhysicalUnit
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class ImperialLengthPhysicalUnit extends PhysicalUnit{

    /**
     * Constructor de ImperialLengthPhysicalUnit
     * 
     * @param abbrev abreviatura de la magnitud de medida
     * @param eqVal valor equivalente de la unidad respecto a la unidad base del sistema
     */
    public ImperialLengthPhysicalUnit(String abbrev, double eqVal) {
        super(abbrev, eqVal, Quantity.LENGTH);
    }
}
