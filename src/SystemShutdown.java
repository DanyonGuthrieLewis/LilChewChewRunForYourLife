import java.util.ArrayList;

import lejos.nxt.Button;

public class SystemShutdown extends Component implements Runnable{
	public static final ComponentType tag = ComponentType.SHUTDOWN;
	
	private IButtonSystem buttonSystem;
	private Thread thread;
	private boolean running = true;

	
	public SystemShutdown(IButtonSystem buttonSystem) {
		thread = new Thread(this);
		this.buttonSystem = buttonSystem;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void start() {
		thread.start();
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		while(running){
			updateThread();
		}
	}
	public void updateThread(){
		if (hasChanged()){
			System.exit(0);
		}
	}
	private boolean hasChanged(){
		return buttonSystem.buttonIsDown();
	}

	public void stop(){
		synchronized (this) {
			running = false;
		}
	}
	@Override
	public ComponentType getType() {
		return tag;
	}
}
