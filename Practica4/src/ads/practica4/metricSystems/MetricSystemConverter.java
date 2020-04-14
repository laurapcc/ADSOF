package ads.practica4.metricSystems;

import ads.practica4.magnitude.IMagnitude;
import ads.practica4.magnitude.Magnitude;
import ads.practica4.magnitude.exceptions.QuantityException;
import ads.practica4.magnitude.exceptions.UnknownUnitException;
import ads.practica4.metricSystems.IMetricSystemConverter;
import ads.practica4.units.IPhysicalUnit;

/**
 * Clase SiLength2ImperialConverter
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class MetricSystemConverter implements IMetricSystemConverter {

    private final IMetricSystem source;
    private final IMetricSystem target;
    private final double multiplicador;

    public MetricSystemConverter(IMetricSystem source, IMetricSystem target, double multiplicador) {
        this.source = source;
        this.target = target;
        this.multiplicador = multiplicador;
    }

    public IMetricSystem sourceSystem() {
        return source;
    }

    public IMetricSystem targetSystem() {
        return target;
    }

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

    public IMetricSystemConverter reverse() {
        IMetricSystemConverter reverse = new MetricSystemConverter(target, source, 1/multiplicador);
        return reverse;
    }
}