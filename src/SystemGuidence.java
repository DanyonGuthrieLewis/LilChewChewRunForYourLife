

public class SystemGuidence extends Component implements ILineObserver{
	public static final String tag = "SystemGuidence";
	private SystemDrive driveSystem;
	private SystemLine lineSystem;
	
	public SystemGuidence() {
		name = tag;
	}
	@Override
	public void initialize() {
		driveSystem = (SystemDrive) entity.getComponent(SystemDrive.tag);
		lineSystem = (SystemLine) entity.getComponent(SystemLine.tag);
		
		lineSystem.addObserver(this);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void lineHitEvent() {
		Direction direction = driveSystem.getDirection();
		if (direction == Direction.FORWARD){
			driveSystem.setDirection(Direction.BACKWARD);
		}
		
	}


}
