package ads.practica4.metricSystems.si.length;

import ads.practica4.quantity.Quantity;
import ads.practica4.units.IPhysicalUnit;
import ads.practica4.magnitude.exceptions.QuantityException;

/**
 * Enumeracion SiLengthMestricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiLengthMetricSystem implements IPhysicalUnit {

    public static final SiLengthMetricSystem MILIMETER = new SiLengthMetricSystem("mm");
    public static final SiLengthMetricSystem METER = new SiLengthMetricSystem("m");
    public static final SiLengthMetricSystem KILOMETER = new SiLengthMetricSystem("km");

    private Quantity quantity = Quantity.L;
    private String abbrev;
    
    private SiLengthMetricSystem(String abbrev) {
        this.abbrev = abbrev;
    }

    public boolean canTransformTo(IPhysicalUnit u) {
        return quantity.equals(u.getQuantity());
    }

    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        return 0.0;
    }
    
    public Quantity getQuantity() {
        return this.quantity;
    }

    public String abbrev() {
        return this.abbrev;
    }

    public String toString() {
        return abbrev + " " + quantity;
    }
}
