package ads.practica4.metricSystems.imperial.length;

import ads.practica4.metricSystems.IMetricSystem;
import ads.practica4.quantity.Quantity;
import ads.practica4.units.*;

import java.util.*;

/**
 * Clase ImperialLengthMestricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class ImperialLengthMetricSystem implements IMetricSystem{

    public static final ImperialLengthMetricSystem SYSTEM = new ImperialLengthMetricSystem();
    public static final IPhysicalUnit INCH = new PhysicalUnit("in", (double)1/12, Quantity.LENGTH);
    public static final IPhysicalUnit FOOT = new PhysicalUnit("ft", 1, Quantity.LENGTH);
    public static final IPhysicalUnit MILE = new PhysicalUnit("mi", 5280, Quantity.LENGTH);

    private ImperialLengthMetricSystem() {}

    /**
     * Devuelve la base del sistema actual
     * 
     * @return : unidad fisica que es la base del sistema
     */
    public IPhysicalUnit base(){
        return FOOT;
    }

    /**
     * Devuelve la coleccion de las unidades del sistema acutal
     * 
     * @return : lista con las unidades del sistema
     */
    public Collection<IPhysicalUnit> units(){
        Collection<IPhysicalUnit> col = new ArrayList<IPhysicalUnit>();
        col.add(MILE);
        col.add(FOOT);
        col.add(INCH);
        return col;
    }
    
}
