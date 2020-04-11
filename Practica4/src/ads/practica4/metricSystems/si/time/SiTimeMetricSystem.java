package ads.practica4.metricSystems.si.time;

import ads.practica4.metricSystems.*;
import ads.practica4.quantity.Quantity;
import ads.practica4.units.*;

import java.util.*;

/**
 * Clase SiTimeMestricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiTimeMetricSystem extends AbstractMetricSystem {

    public static final IMetricSystem SYSTEM = new SiTimeMetricSystem();
    public static final IPhysicalUnit MILISECOND = new PhysicalUnit("ms", 0.001, Quantity.TIME, SYSTEM);
    public static final IPhysicalUnit SECOND = new PhysicalUnit("s", 1, Quantity.TIME, SYSTEM);
    public static final IPhysicalUnit HOUR = new PhysicalUnit("h", 3600, Quantity.TIME, SYSTEM);

    private SiTimeMetricSystem() {}

    /**
     * Devuelve la base del sistema actual
     * 
     * @return : unidad fisica que es la base del sistema
     */
    public IPhysicalUnit base(){
        return SECOND;
    }

    /**
     * Devuelve la coleccion de las unidades del sistema acutal
     * 
     * @return : lista con las unidades del sistema
     */
    public Collection<IPhysicalUnit> units(){
        Collection<IPhysicalUnit> col = new ArrayList<IPhysicalUnit>();
        col.add(HOUR);
        col.add(SECOND);
        col.add(MILISECOND);
        return col;
    }
}
