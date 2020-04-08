package ads.practica4.magnitude;

import ads.practica4.magnitude.exceptions.QuantityException;
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
        value += m.transformTo(unit).getValue();
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
        value -= m.transformTo(unit).getValue();
        return this;
    }

    /**
     * Devuelve la magnitud actual transformada a la unidad fisica c
     * 
     * @param c unidad fisica a la cual queremos transformar la unidad actual
     * @return : magnitud acutal con la nueva unidad fisica
     */
    public IMagnitude transformTo(IPhysicalUnit c) throws QuantityException {
        if (!unit.canTransformTo(c))
            throw new QuantityException("Quantities " + c.getQuantity() + " and " + getUnit().getQuantity() + " are not compatible");
        
        value = unit.transformTo(value, c);
        unit = c;

        return this;
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