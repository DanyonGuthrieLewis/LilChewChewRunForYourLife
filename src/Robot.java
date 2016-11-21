

public class Robot extends Entity{

	public Robot(IDriveSystem driveSystem, ILineSystem lineSystem) {
		addComponent(new SystemDrive(driveSystem));
		addComponent(new SystemLine(lineSystem));
		addComponent(new SystemGuidence());
		initialize();
	}

	@Override
	protected void updateEntity() {
		// TODO Auto-generated method stub
		
	}
	
}
