package robot;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class LeJOS_LightSensor implements ILineSystem{
	private LightSensor lightSensor;
	
	public LeJOS_LightSensor() {
		lightSensor = new LightSensor(SensorPort.S2);
		lightSensor.setFloodlight(true);
	}
	public int getLightValue(){
		return lightSensor.getLightValue();
	}
}