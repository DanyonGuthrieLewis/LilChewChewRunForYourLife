package robot;

import lejos.nxt.SensorPort;

public class BattleBot {
	public static void main(String[] args){
		LeJOS_DriveSystem drive = new LeJOS_DriveSystem();
		LeJOS_LightSensor line = new LeJOS_LightSensor(SensorPort.S2);
		
		Robot lilchewchew = new Robot(drive, line);
		lilchewchew.initialize();
		lilchewchew.start();
	}
}
