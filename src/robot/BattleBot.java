package robot;

public class BattleBot {
	public static void main(String[] args){
		LeJOS_DriveSystem drive = new LeJOS_DriveSystem();
		LeJOS_LightSensor line = new LeJOS_LightSensor();
		Robot lilchewchew = new Robot(drive, line);
		lilchewchew.initialize();
		lilchewchew.start();
	}
}
