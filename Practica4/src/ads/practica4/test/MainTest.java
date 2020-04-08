package ads.practica4.test;

import ads.practica4.magnitude.IMagnitude;
import ads.practica4.magnitude.Magnitude;
import ads.practica4.magnitude.exceptions.QuantityException;
import ads.practica4.metricSystems.si.length.SiLengthMetricSystem;
import ads.practica4.metricSystems.si.time.SiTimeMetricSystem;

public class MainTest {

	public static void main(String[] args) throws QuantityException{
		IMagnitude m  = new Magnitude(12.5, SiLengthMetricSystem.KILOMETER);
		Magnitude m2 = new Magnitude(12.5, SiLengthMetricSystem.METER);
								
		System.out.println(m2.add(m));				// m converted to meters and added to m2
		System.out.println(m.subs(m2).add(m2));		// operations can be chained
		System.out.println(m.transformTo(SiLengthMetricSystem.METER));
		
		Magnitude s1 = new Magnitude(65, SiTimeMetricSystem.SECOND);
		
		try {
			System.out.println(s1.add(m));
		} catch (QuantityException q) {
			System.out.println(q);
		}
	}

}
