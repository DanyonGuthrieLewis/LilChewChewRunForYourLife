

import java.util.ArrayList;

public class SystemLine extends Component implements Runnable{
	public static final ComponentType tag = ComponentType.LINE;
	private static final int MEDIAN_VALUE = 30;
	
	private Thread thread;
	
	private ArrayList<ILineObserver> observers;
	
	private ILineSystem lineSystem;
	private boolean running = true;
	
	private boolean previousResult = false;
	private boolean currentResult = false;
	
	public SystemLine(ILineSystem lineSystem) {
		this.lineSystem = lineSystem;
		thread = new Thread(this);
		observers = new ArrayList<>();
	}
	@Override
	public void initialize() {
		
	}
	@Override
	public void start() {
		thread.start();
	}
	public void addObserver(ILineObserver observer){
		observers.add(observer);
	}
	@Override
	public void update() {

	}
	@Override
	public void run() {
		while(running){
			updateThread();
		}
	}
	public void updateThread(){
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
		trySleep(500);
	}
	private void trySleep(long duration){
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
