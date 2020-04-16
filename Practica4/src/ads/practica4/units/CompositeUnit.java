package ads.practica4.units;

import ads.practica4.magnitude.IMagnitude;
import ads.practica4.magnitude.Magnitude;
import ads.practica4.magnitude.exceptions.QuantityException;
import ads.practica4.metricSystems.IMetricSystem;
import ads.practica4.quantity.Quantity;
import ads.practica4.units.ICompositeUnit.*;

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

    /**
     * Constructor de CompositeUnit
     * 
     * @param leftUnit unidad fisica situada a la izquierda en la unidad compuesta
     * @param operator relacion entre unidades izquierda y derecha
     * @param rightUnit unidad fisica situada a la derecha en la unidad compuesta
     */
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
     * Devuelve la unidad fisica situada a la derecha de la unidad compuesta
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
            if (leftUnit.canTransformTo(((CompositeUnit)u).getLeftUnit()) && 
                rightUnit.canTransformTo(((CompositeUnit)u).getRightUnit()))
                return true;
        }
        return false;
    }

    /**
     * Transforma la unidad d de la magnitud actual a la pasada como argumento
     * solo si se trata de unidades compuestas y la conversion es posible
     * 
     * @param d : cantidad que queremos cambiar de magnitud
     * @param u : unidad de medida a la cual queremos transformar
     * @return : resultado de la transformacion
     */
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        if (!canTransformTo(u))
            throw new QuantityException("Quantities " + u.getQuantity() + " and " + getQuantity() + " are not compatible"); 

        IMagnitude leftMagnitude = new Magnitude(1, leftUnit);
        IMagnitude rightMagnitude = new Magnitude(1, rightUnit);
        leftMagnitude = leftMagnitude.transformTo(((CompositeUnit)u).getLeftUnit());
        rightMagnitude = rightMagnitude.transformTo(((CompositeUnit)u).getRightUnit());
        double val1 = leftMagnitude.getValue();
        double val2 = rightMagnitude.getValue();

        if (operator.equals(Operator.MUL))
            return d*val1*val2;
        else
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
     * @return : abreviatuda de la unidad de la izquierda, el operador como simbolo y 
     *           la abreviatura de la unidad de la derecha
     */
    public String abbrev() {
        return leftUnit.abbrev() + operator + rightUnit.abbrev();
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
     * @return : String representando la unidad compuesta
     */
    @Override
    public String toString() {
        return abbrev();
    }
}