package ads.practica4.test;

import ads.practica4.units.IPhysicalUnit;
import ads.practica4.magnitude.exceptions.QuantityException;
import ads.practica4.metricSystems.si.length.*;
import ads.practica4.metricSystems.si.time.*;

public class PhysicalUnitTest {
	public static void main(String[] args) throws QuantityException {
		IPhysicalUnit meter = SiLengthMetricSystem.METER;
		System.out.println(meter);   				// This is how a meter is printed (abrev + Quantity)
		System.out.println(meter.canTransformTo(SiLengthMetricSystem.KILOMETER));   // Yes, we can
		System.out.println(meter.canTransformTo(SiTimeMetricSystem.SECOND));  		// No, we don't
		System.out.println("1000 m en km: "+meter.transformTo(1000, SiLengthMetricSystem.KILOMETER));
		try {
			System.out.println("1000 m en s: "+meter.transformTo(1000, SiTimeMetricSystem.SECOND)); // Exception!
		} catch (QuantityException e) {
			System.out.println(e);
		}
	}
}
