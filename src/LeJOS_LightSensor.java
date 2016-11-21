

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class LeJOS_LightSensor implements ILineSystem{
	private LightSensor lightSensor;
	
	public LeJOS_LightSensor(SensorPort sensorPort) {
		lightSensor = new LightSensor(sensorPort);
		lightSensor.setFloodlight(true);
	}
	public int getLightValue(){
		return lightSensor.getLightValue();
	}
}
