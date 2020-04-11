package ads.practica4.metricSystems.si.length;

import ads.practica4.metricSystems.*;
import ads.practica4.quantity.Quantity;
import ads.practica4.units.*;

import java.util.*;

/**
 * Clase SiLengthMestricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiLengthMetricSystem extends AbstractMetricSystem {

    public static final IMetricSystem SYSTEM = new SiLengthMetricSystem();
    public static final IPhysicalUnit MILIMETER = new PhysicalUnit("mm", 0.001, Quantity.LENGTH, SYSTEM);
    public static final IPhysicalUnit METER = new PhysicalUnit("m", 1, Quantity.LENGTH, SYSTEM);
    public static final IPhysicalUnit KILOMETER = new PhysicalUnit("km", 1000, Quantity.LENGTH, SYSTEM);

    private SiLengthMetricSystem() {
    }

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
