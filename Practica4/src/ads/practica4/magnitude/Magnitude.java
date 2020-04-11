package ads.practica4.magnitude;

import ads.practica4.magnitude.exceptions.QuantityException;
import ads.practica4.magnitude.exceptions.UnknownUnitException;
import ads.practica4.metricSystems.IMetricSystem;
import ads.practica4.metricSystems.IMetricSystemConverter;
import ads.practica4.units.*;

/**
 * Clase Magnitude
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Magnitude implements IMagnitude{

    double value;
    IPhysicalUnit unit;

    /**
     * Constructor de Magnitude
     * 
     * @param value valor numerico de la magnitud
     * @param unit tipo de unidad de la magnitud
     */
    public Magnitude(double value, IPhysicalUnit unit){
        this.value = value;
        this.unit = unit;
    }

    /**
     * Anade la magnitud m a la magnitud actual, realizando las transformaciones
     * correspondientes
     * 
     * @param m magnitud que se quiere anadir
     * @return : magnitud actual con la adicion realizada
     */
    public IMagnitude add(IMagnitude m) throws QuantityException {
        value += m.getUnit().transformTo(m.getValue(), unit);
        return this;
    }

    /**
     * Sustrae la magnitud m de la magnitud actual, realizando las transformaciones
     * correspondientes
     * 
     * @param m magnitud que se quiere anadir
     * @return : magnitud actual con la sustraccion realizada
     */
    public IMagnitude subs(IMagnitude m) throws QuantityException {
        value -= m.getUnit().transformTo(m.getValue(), unit);
        return this;
    }

    /**
     * Devuelve la magnitud actual transformada a la unidad fisica c
     * 
     * @param c unidad fisica a la cual queremos transformar la unidad actual
     * @return : magnitud acutal con la nueva unidad fisica
     */
    public IMagnitude transformTo(IPhysicalUnit c) throws QuantityException {
        if (unit.canTransformTo(c)) {
            value = unit.transformTo(value, c);
            unit = c;
            return this;
        }
        else {
            IMetricSystem unitMS = unit.getMetricSystem();
            IMetricSystem cMS = c.getMetricSystem();
            IMetricSystemConverter converter = unitMS.getConverter(cMS);
            if (converter == null)
                throw new QuantityException("Cannot transform " + unit + " to " + c);
            else {
                transformTo(unitMS.base());
                try {
                    value = converter.transformTo(this, cMS.base()).getValue();
                    unit = cMS.base();
                } catch(UnknownUnitException e) {
                    throw new QuantityException("Cannot transform " + unit + " to " + c);
                }
                transformTo(c);
                return this;
            }
        }
    }

    /**
     * Devuelve la unidad de la magnitud
     * 
     * @return : unidad fisica de la magnitud actual
     */
    public IPhysicalUnit getUnit() {
        return this.unit;
    }

    /**
     * Devuelve el valor numerico de la magnitud
     * 
     * @return : valor de la magnitud actual
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Devuelve el String formado por la abreviatura de la magnitud y su
     * quantity
     * 
     * @return : String formado por abbrev y quantity
     */
    @Override
    public String toString() {
        return value + " [" + unit + "]";
    }
}