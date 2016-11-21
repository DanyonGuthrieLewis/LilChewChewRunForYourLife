package robot;

public class SystemDrive extends Component{
	public static final String tag = "SystemDrive";
	private IDriveSystem driveSystem;
	public SystemDrive(IDriveSystem driveSystem) {
		this.driveSystem = driveSystem;
	}
	public SystemDrive() {
		name = tag;
	}
	@Override
	public void initialize() {
		
	}
	@Override
	public void update() {
		driveSystem.move();
	}

}
