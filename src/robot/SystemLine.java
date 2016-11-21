package robot;

import java.util.ArrayList;

public class SystemLine extends Component implements Runnable{
	private final static int MEDIAN_VALUE = 100;
	
	private Thread thread;
	
	private ArrayList<ILineObserver> observers;
	
	private ILineSystem lineSystem;
	private boolean running = true;
	
	private boolean previousResult = false;
	private boolean currentResult = false;
	
	public SystemLine(ILineSystem lineSystem) {
		name = "SystemLine";
		this.lineSystem = lineSystem;
		thread = new Thread(this);
	}
	@Override
	public void initialize() {
		thread.run();
	}
	public void addObserver(ILineObserver observer){
		observers.add(observer);
	}
	@Override
	public void update() {
		if (hasChanged()){
			notifyObservers();
		}
	}
	private boolean hasChanged(){
		boolean changed = false;
		currentResult = (lineSystem.getLightValue() >= MEDIAN_VALUE);
		changed = (currentResult != previousResult);
		return changed;
	}
	private void notifyObservers(){
		for (ILineObserver observer : observers){
			synchronized(observer){
				observer.lineHitEvent();
			}
		}
	}
	@Override
	public void run() {
		while(running){
			update();
		}
	}
	public void stop(){
		synchronized (this) {
			running = false;
		}
	}
}
