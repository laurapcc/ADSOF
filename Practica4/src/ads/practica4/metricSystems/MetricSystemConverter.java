package ads.practica4.metricSystems;

import ads.practica4.magnitude.IMagnitude;
import ads.practica4.magnitude.Magnitude;
import ads.practica4.magnitude.exceptions.QuantityException;
import ads.practica4.magnitude.exceptions.UnknownUnitException;
import ads.practica4.metricSystems.IMetricSystemConverter;
import ads.practica4.units.IPhysicalUnit;

/**
 * Clase MetricSystemConverter
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class MetricSystemConverter implements IMetricSystemConverter {

    private final IMetricSystem source;
    private final IMetricSystem target;
    private final double multiplicador;

    /**
     * Constructor de la clase MetricSystemConverter
     * 
     * @param source : sistema metrico origen de la conversion 
     * @param target : sistema metrico destino de la conversion 
     * @param multiplicador : factor por el que se ha de multiplicar la unidad base del sistema origen
     * para transformala en una unidad de la base del sistema destino
     */
    public MetricSystemConverter(IMetricSystem source, IMetricSystem target, double multiplicador) {
        this.source = source;
        this.target = target;
        this.multiplicador = multiplicador;
    }

    /**
     * Devuelve el sistema metrico origen
     * 
     * @return : sistema metrico origen
     */
    public IMetricSystem sourceSystem() {
        return source;
    }

    /**
     * Devuelve el sistema metrico destino
     * 
     * @return : sistema metrico destino
     */
    public IMetricSystem targetSystem() {
        return target;
    }

    /**
     * Permite a un conversor transformar una magnitud fisica del sistema origen en una magnitud
     * del del sistema destino, cuya unidad es pasada como argumento
     * 
     * @param from : magnitud a transformar
     * @param to : unidad fisica a la que se ha de transformar la magnitud from
     * @return : magnitud con unidad fisica to a la que se ha transformado la magnitud from
     */
    public IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException {
        if (!source.units().contains(from.getUnit()) || !target.units().contains(to))
            throw new UnknownUnitException("Invalid Physical Unit");
        
        try {
            from.transformTo(source.base());
            ((Magnitude)from).setUnit(target.base());
            ((Magnitude)from).setValue(from.getValue()*multiplicador);
            from.transformTo(to);
        } catch (QuantityException e) {
            throw new UnknownUnitException("Invalid Physical Unit");
        }
        
        return from;
    }

    /**
     * Crea el conversor inverso del conversor actual
     * 
     * @return : conversor inverso
     */
    public IMetricSystemConverter reverse() {
        IMetricSystemConverter reverse = new MetricSystemConverter(target, source, 1/multiplicador);
        return reverse;
    }
}