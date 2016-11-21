

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class SystemSight extends Component{
	public static final String tag = "SystemSight";
	
	private UltrasonicSensor ultrasonicSensor;
	
	public SystemSight(SensorPort sensorPort) {
		ultrasonicSensor = new UltrasonicSensor(sensorPort);
	}
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
