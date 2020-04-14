package ads.practica4.units;

import ads.practica4.magnitude.exceptions.QuantityException;
import ads.practica4.metricSystems.IMetricSystem;
import ads.practica4.quantity.Quantity;
import ads.practica4.units.ICompositeUnit.ICompositeUnit;
import ads.practica4.units.ICompositeUnit.Operator;

/**
 * Clase CompositeUnit
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class CompositeUnit implements ICompositeUnit {

    private Operator operator;
    private IPhysicalUnit leftUnit;
    private IPhysicalUnit rightUnit;

    public CompositeUnit(IPhysicalUnit leftUnit, Operator operator, IPhysicalUnit rightUnit) {
        this.operator = operator;
        this.leftUnit = leftUnit;
        this.rightUnit = rightUnit;
    }

    /**
     * Devuelve el operador de la unidad compuesta
     * 
     * @return : Operator
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * Devuelve la unidad fisica situada a la izquierda de la unidad compuesta
     * 
     * @return : IPhysicalUnit
     */
    public IPhysicalUnit getLeftUnit() {
        return leftUnit;
    }

    /**
     * Devuelve la unidad fisica situada a la izquierda de la unidad compuesta
     * 
     * @return : IPhysicalUnit
     */
    public IPhysicalUnit getRightUnit() {
        return rightUnit;
    }

    /**
     * Comprueba si se puede transormar la magnitud actual a la que es pasada
     * como argumento
     * 
     * @param u : unidad de medida que queremos comprobar
     * @return : true si se puede transomar, false en caso contrario
     */
    public boolean canTransformTo(IPhysicalUnit u) {
        if (u instanceof CompositeUnit) {
            if (!leftUnit.getMetricSystem().equals(((CompositeUnit)u).getLeftUnit().getMetricSystem()) || 
                !rightUnit.getMetricSystem().equals(((CompositeUnit)u).getRightUnit().getMetricSystem())) {
                if (leftUnit.getMetricSystem().getConverter(((CompositeUnit)u).getLeftUnit().getMetricSystem()) != null &&
                    rightUnit.getMetricSystem().getConverter(((CompositeUnit)u).getRightUnit().getMetricSystem()) != null)
                    return true;
            }
            else {
                return true;
            }
        }
        return false;
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
            throw new QuantityException("Quantities " + u.getQuantity() + " and " + getQuantity() + " are not compatible"); 

        double val1 = ((PhysicalUnit)leftUnit).getEqVal();
        double val2 = ((PhysicalUnit)u).getEqVal();

        return d*(val1/val2);
    }

    /**
     * Devuelve el quantity de la unidad fisica de la izquierda de la unidad compuesta
     * 
     * @return : quantity de la magnitud actual
     */
    public Quantity getQuantity() {
        return leftUnit.getQuantity();
    }

    /**
     * Devuelve la abreviatura de la magnitud
     * 
     * @return : atributo abbrev de la magnitud
     */
    public String abbrev() {
        if (operator.equals(Operator.MUL))
            return leftUnit.abbrev() + " * " + rightUnit.abbrev();
        else
            return leftUnit.abbrev() + " / " + rightUnit.abbrev();
    }

    /**
     * Devuelve el sistema metrico al que pertenece la unidad fisica izquierda
     * 
     * @return : sistema metrico de la unidad fisica
     */
    public IMetricSystem getMetricSystem() {
        return leftUnit.getMetricSystem();
    }

    /**
     * Devuelve el String formado por la abreviatura de la unidad compuesta
     * 
     * @return : String formado por abbrev
     */
    @Override
    public String toString() {
        return abbrev();
    }
}