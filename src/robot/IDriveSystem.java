package robot;

public interface IDriveSystem {
	void setDirection(Direction direction);
	Direction getDirection(); 
	void move();
}
