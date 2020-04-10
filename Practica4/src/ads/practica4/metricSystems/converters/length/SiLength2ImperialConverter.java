package ads.practica4.metricSystems.converters.length;

import ads.practica4.magnitude.IMagnitude;
import ads.practica4.magnitude.exceptions.QuantityException;
import ads.practica4.metricSystems.*;
import ads.practica4.metricSystems.imperial.length.ImperialLengthMetricSystem;
import ads.practica4.metricSystems.si.length.SiLengthMetricSystem;
import ads.practica4.units.IPhysicalUnit;
import ads.practica4.units.exceptions.UnknownUnitException;

/**
 * Clase SiLength2ImperialConverter
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class SiLength2ImperialConverter implements IMetricSystemConverter{

    public IMetricSystem sourceSystem(){
        return SiLengthMetricSystem.SYSTEM;
    }

    public IMetricSystem targetSystem(){
        return ImperialLengthMetricSystem.SYSTEM;
    }

    public IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException{
        if (!targetSystem().units().contains(to))
            throw new UnknownUnitException("La unidad ["+to+"] no pertenece al sistema de destino, cuyas unidades son ["+targetSystem().units()+"]");
        
        try{
            return from.transformTo(to);
        }catch(QuantityException e){
            return null; //de momento
        }
    }

    public IMetricSystemConverter reverse(){
        
    }   

}