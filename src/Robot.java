import lejos.nxt.Button;
import lejos.nxt.Sound;

public class Robot extends Entity{

	public Robot(IDriveSystem driveSystem, ILineSystem lineSystem, IButtonSystem shutdown) {
		Sound.setVolume(Sound.VOL_MAX);
		validateComponentAdded(addComponent(new SystemDrive(driveSystem)));
		trySleep(100);
		validateComponentAdded(addComponent(new SystemLine(lineSystem)));
		trySleep(100);
		validateComponentAdded(addComponent(new SystemGuidence()));
		trySleep(100);
		validateComponentAdded(addComponent(new SystemShutdown(shutdown)));
		initialize();
	}
	private void validateComponentAdded(boolean added){
		if (added){
			Sound.playTone(800, 100);
		}
		else {
			Sound.playTone(400, 100);
		}
	}
	private void trySleep(long duration){
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
