package ads.practica4.units.si.time;

import ads.practica4.quantity.Quantity;
import ads.practica4.units.PhysicalUnit;

/**
 * Clase SiTimePhysicalUnit
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiTimePhysicalUnit extends PhysicalUnit{

    /**
     * Constructor de SiTimePhysicalUnit
     * 
     * @param abbrev abreviatura de la magnitud de medida
     * @param eqVal valor equivalente de la unidad respecto a la unidad base del sistema
     * @param quantity elemento de la enumeracion que indica que cantidad mide la unidad
     */
    public SiTimePhysicalUnit(String abbrev, double eqVal) {
        super(abbrev, eqVal, Quantity.TIME);
    }
}
