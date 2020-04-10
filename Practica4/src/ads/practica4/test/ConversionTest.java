package ads.practica4.test;

import ads.practica4.magnitude.IMagnitude;
import ads.practica4.magnitude.Magnitude;
import ads.practica4.magnitude.exceptions.QuantityException;
//import ads.practica4.metricSystems.AbstractMetricSystem;
import ads.practica4.metricSystems.imperial.length.ImperialLengthMetricSystem;
import ads.practica4.metricSystems.si.length.SiLengthMetricSystem;
import ads.practica4.metricSystems.converters.length.SiLength2ImperialConverter;


public class ConversionTest {

	public static void main(String[] args) throws QuantityException {
		Magnitude m  = new Magnitude(10, SiLengthMetricSystem.KILOMETER);
								
		IMagnitude enMillas = null;
		
		try {
			enMillas = m.transformTo(ImperialLengthMetricSystem.MILE);
		} catch (QuantityException e) {
			System.out.println(e);
		}
		SiLengthMetricSystem.registerConverter(new SiLength2ImperialConverter());	// This register the converter and the reverse
		enMillas = m.transformTo(ImperialLengthMetricSystem.MILE);
		
		System.out.println("En millas = "+enMillas);
		System.out.println("En m = "+ enMillas.transformTo(SiLengthMetricSystem.METER)); 			
	}

}

