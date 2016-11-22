
public class SystemDrive extends Component{
	public static final ComponentType tag = ComponentType.DRIVE;
	private static final Direction STARTING_DIRECTION = Direction.FORWARD;
	private IDriveSystem driveSystem;
	public SystemDrive(IDriveSystem driveSystem) {
		this.driveSystem = driveSystem;
	}
	@Override
	public void initialize() {
	
	}
	@Override
	public void start() {
		setDirection(STARTING_DIRECTION);
	}
	public void setDirection(Direction direction){
		driveSystem.setDirection(direction);
	}
	public Direction getDirection(){
		return driveSystem.getDirection();
	}
	@Override
	public void update() {
		driveSystem.move();
	}
	@Override
	public ComponentType getType() {
		return tag;
	}

}
