

import lejos.nxt.Motor;

public class LeJOS_DriveSystem implements IDriveSystem{
	private final static int FORWARD_SPEED = 500;
	private final static int BACKWARD_SPEED = 500;
	private final static int TURN_SPEED = 200;

	private Direction direction;
	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
		switch(direction){
			case FORWARD:
				setForward();
				break;
			case BACKWARD:
				setBackward();
				break;
			case LEFT:
				setLeft();
				break;
			case RIGHT:
				setRight();
				break;
		}
	}

	private void setForward(){
		Motor.A.setSpeed(FORWARD_SPEED);
		Motor.B.setSpeed(FORWARD_SPEED);
	}
	private void setBackward(){
		Motor.A.setSpeed(BACKWARD_SPEED);
		Motor.B.setSpeed(BACKWARD_SPEED);
	}
	private void setLeft(){
		Motor.A.setSpeed(TURN_SPEED);
		Motor.B.setSpeed(TURN_SPEED);
	}
	private void setRight(){
		Motor.A.setSpeed(TURN_SPEED);
		Motor.B.setSpeed(TURN_SPEED);
	}
	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public void move() {
		switch(direction){
		case FORWARD:
			moveForward();
			break;
		case BACKWARD:
			moveBackward();
			break;
		case LEFT:
			moveLeft();
			break;
		case RIGHT:
			moveRight();
			break;
		}
	}
	private void moveForward(){
		Motor.A.forward();
		Motor.B.forward();
	}
	private void moveBackward(){
		Motor.A.backward();
		Motor.B.backward();
	}
	private void moveLeft(){
		Motor.A.backward();
		Motor.B.forward();
	}
	private void moveRight(){
		Motor.A.forward();
		Motor.B.backward();
	}
}
