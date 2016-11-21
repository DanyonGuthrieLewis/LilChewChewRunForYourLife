import lejos.nxt.SensorPort;

public class Main {

	public static void main(String[] args) {
		LeJOS_DriveSystem drive = new LeJOS_DriveSystem();
		LeJOS_LightSensor light = new LeJOS_LightSensor(SensorPort.S2);
		
		Robot lilchewchew = new Robot(drive, light);
		lilchewchew.initialize();
		lilchewchew.start();
	}

}
