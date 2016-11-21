

import java.util.ArrayList;

public class SystemLine extends Component implements Runnable{
	public static final String tag = "SystemLine";
	private static final int MEDIAN_VALUE = 50;
	
	private Thread thread;
	
	private ArrayList<ILineObserver> observers;
	
	private ILineSystem lineSystem;
	private boolean running = true;
	
	private boolean previousResult = false;
	private boolean currentResult = false;
	
	public SystemLine(ILineSystem lineSystem) {
		name = tag;
		this.lineSystem = lineSystem;
		thread = new Thread(this);
	}
	@Override
	public void initialize() {
		
	}
	@Override
	public void start() {
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
