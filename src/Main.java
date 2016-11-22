import lejos.nxt.Button;
import lejos.nxt.SensorPort;

public class Main {

	public static void main(String[] args) {
		LeJOS_DriveSystem drive = new LeJOS_DriveSystem();
		LeJOS_LightSensor light = new LeJOS_LightSensor(SensorPort.S3);
		LeJOS_Button shutdown = new LeJOS_Button(Button.ENTER);
		Robot lilchewchew = new Robot(drive, light, shutdown);
		lilchewchew.start();
	}

}
