package ads.practica4.units;

import ads.practica4.quantity.Quantity;
import ads.practica4.units.IPhysicalUnit;
import ads.practica4.magnitude.exceptions.QuantityException;

/**
 * Clase PhysicalUnit
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class PhysicalUnit implements IPhysicalUnit {

    private final Quantity quantity;
    private final String abbrev;
    private final double eqVal;

    /**
     * Constructor de PhysicalUnit
     * 
     * @param abbrev abreviatura de la magnitud de medida
     * @param eqVal valor equivalente de la unidad respecto a la unidad base del sistema
     * @param quantity elemento de la enumeracion que indica que cantidad mide la unidad
     */
    protected PhysicalUnit(String abbrev, double eqVal, Quantity quantity) {
        this.abbrev = abbrev;
        this.eqVal = eqVal;
        this.quantity = quantity;
    }

    /**
     * Devuelve el atributo eqVal
     * 
     * @return : valor equivalente, es la cantidad de unidades basicas que
     * hay en la magnitud actual
     */
    public double getEqVal() {
        return this.eqVal;
    }

    /**
     * Comprueba si se puede transormar la magnitud actual a la que es pasada
     * como argumento
     * 
     * @param u : unidad de medida que queremos comprobar
     * @return : true si se puede transomar, false en caso contrario
     */
    public boolean canTransformTo(IPhysicalUnit u) {
        return this.getClass().equals(u.getClass());
    }

    /**
     * Transforma la unidad d de la magnitud actual a la pasada como argumento
     * 
     * @param d : cantidad que queremos cambiar de magnitud
     * @param u : unidad de medida a la cual queremos transformar
     * @return : resultado de la transformacion
     */
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        if (!canTransformTo(u))
            throw new QuantityException("Quantities " + u.getQuantity() + " and " + quantity + " are not compatible"); 

        double val1 = this.eqVal;
        double val2 = ((PhysicalUnit)u).getEqVal();

        return d*(val1/val2);
    }

    /**
     * Devuelve el quantity de la magnitud
     * 
     * @return : quantity de la magnitud actual
     */
    public Quantity getQuantity() {
        return this.quantity;
    }

    /**
     * Devuelve la abreviatura de la magnitud
     * 
     * @return : atributo abbrev de la magnitud
     */
    public String abbrev() {
        return this.abbrev;
    }

    /**
     * Devuelve el String formado por la abreviatura de la magnitud y su
     * quantity
     * 
     * @return : String formado por abbrev y quantity
     */
    @Override
    public String toString() {
        return abbrev + " " + quantity.toString();
    }
}
