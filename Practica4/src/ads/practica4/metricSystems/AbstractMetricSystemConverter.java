package ads.practica4.metricSystems;

import ads.practica4.magnitude.IMagnitude;
import ads.practica4.magnitude.exceptions.UnknownUnitException;
import ads.practica4.metricSystems.IMetricSystem;
import ads.practica4.metricSystems.IMetricSystemConverter;
import ads.practica4.metricSystems.imperial.length.ImperialLengthMetricSystem;
import ads.practica4.metricSystems.si.length.SiLengthMetricSystem;
import ads.practica4.units.IPhysicalUnit;

/**
 * Clase SiLength2ImperialConverter
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public abstract class AbstractMetricSystemConverter implements IMetricSystemConverter {

    private IMetricSystem source;
    private IMetricSystem target;
    private double multiplicador;

    public AbstractMetricSystemConverter(IMetricSystem source, IMetricSystem target, double multiplicador) {
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
        
    }

    public IMetricSystemConverter reverse() {
        IMetricSystemConverter reverse = new AbstractMetricSystemConverter(target, source, 1/multiplicador);
        return reverse;
    }
}