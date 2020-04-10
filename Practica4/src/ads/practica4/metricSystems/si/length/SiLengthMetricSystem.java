package ads.practica4.metricSystems.si.length;

import ads.practica4.metricSystems.*;
import ads.practica4.quantity.Quantity;
import ads.practica4.units.*;
import ads.practica4.units.si.length.SiLengthPhysicalUnit;

import java.util.*;

/**
 * Clase SiLengthMestricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiLengthMetricSystem implements IMetricSystem {

    public static final IMetricSystem SYSTEM = new SiLengthMetricSystem();
    public static final IPhysicalUnit MILIMETER = new SiLengthPhysicalUnit("mm", 0.001);
    public static final IPhysicalUnit METER = new SiLengthPhysicalUnit("m", 1);
    public static final IPhysicalUnit KILOMETER = new SiLengthPhysicalUnit("km", 1000);

    private SiLengthMetricSystem() {}

    /**
     * Devuelve la base del sistema actual
     * 
     * @return : unidad fisica que es la base del sistema
     */
    public IPhysicalUnit base() {
        return METER;
    }

    /**
     * Devuelve la coleccion de las unidades del sistema acutal
     * 
     * @return : lista con las unidades del sistema
     */
    public Collection<IPhysicalUnit> units() {
        Collection<IPhysicalUnit> col = new ArrayList<IPhysicalUnit>();
        col.add(KILOMETER);
        col.add(METER);
        col.add(MILIMETER);
        return col;
    }
}
