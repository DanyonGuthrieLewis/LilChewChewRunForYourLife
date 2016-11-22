

public class SystemGuidence extends Component implements ILineObserver{
	public static final ComponentType tag = ComponentType.GUIDENCE;
	private SystemDrive driveSystem;
	private SystemLine lineSystem;
	
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
		else if (direction == Direction.BACKWARD){
			driveSystem.setDirection(Direction.FORWARD);
		}
	}

	@Override
	public ComponentType getType() {
		return tag;
	}

	
}
