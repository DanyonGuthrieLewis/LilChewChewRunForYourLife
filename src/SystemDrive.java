
public class SystemDrive extends Component{
	public static final String tag = "SystemDrive";
	private static final Direction STARTING_DIRECTION = Direction.FORWARD;
	private IDriveSystem driveSystem;
	public SystemDrive(IDriveSystem driveSystem) {
		this.driveSystem = driveSystem;
	}
	public SystemDrive() {
		name = tag;
		setDirection(STARTING_DIRECTION);
	}
	@Override
	public void initialize() {
	
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
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

}
