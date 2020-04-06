package ads.practica4.metricSystems.si.time;

import ads.practica4.quantity.Quantity;
import ads.practica4.units.IPhysicalUnit;
import ads.practica4.magnitude.exceptions.QuantityException;

/**
 * Enumeracion SiTimeMestricSystem
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiTimeMetricSystem implements IPhysicalUnit{

    public static final SiTimeMetricSystem SECOND = new SiTimeMetricSystem("s");

    private Quantity quantity = Quantity.t;
    private String abbrev;

    private SiTimeMetricSystem(String abbrev) {
        this.abbrev = abbrev;
    }

    public boolean canTransformTo(IPhysicalUnit u) {
        return quantity.equals(u.getQuantity());
    }

    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {

    }

    public Quantity getQuantity() {
        return this.quantity;
    }

    public String abbrev() {
        return this.abbrev;
    }

    public String toString() {
        return abbrev+quantity;
    }
}
