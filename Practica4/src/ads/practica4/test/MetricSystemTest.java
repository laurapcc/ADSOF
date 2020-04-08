package ads.practica4.test;

import ads.practica4.metricSystems.IMetricSystem;
import ads.practica4.metricSystems.imperial.length.ImperialLengthMetricSystem;
import ads.practica4.metricSystems.si.length.SiLengthMetricSystem;

public class MetricSystemTest {
	public static void main(String[] args) {
		IMetricSystem ms = SiLengthMetricSystem.SYSTEM;
		//new SiLengthMetricSystem();	// dara error de compilacion
		System.out.println(ms.units());
		System.out.println("Base = "+ms.base());
		
		System.out.println(SiLengthMetricSystem.METER.canTransformTo(ImperialLengthMetricSystem.FOOT));
		// No: different metric systems
	}

}
