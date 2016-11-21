
import java.util.ArrayList;

public abstract class Entity {
	private ArrayList<Component> components = new ArrayList<>();
	private boolean running = true;
	
	public boolean addComponent(Component component){
		boolean canAdd = true;
		for (Component existing : components){
			if (existing.getName().equals(component.getName()));
		}
		if (canAdd){
			component.setEntity(this);
			components.add(component);
		}
		return canAdd;
	}
	public void initialize(){
		for (Component component : components){
			component.initialize();
		}
	}
	public void start(){
		for (Component component : components){
			component.start();
		}
		run();
	}
	private void run(){
		while (running){
			update();
		}
	}
	public boolean removeComponent(String name){
		boolean canRemove = false;
		Component toRemove = null;
		for (Component component : components){
			if (component.getName().equals(name)){
				canRemove = true;
				toRemove = component;
			}
		}
		if (canRemove){
			components.remove(toRemove);
		}
		return canRemove;
	}
	public Component getComponent(String name){
		Component toGet = null;
		for (Component component : components){
			if (component.getName().equals(name)){
				toGet = component;
				break;
			}
		}
		return toGet;
	}
	
	private void update(){
		updateEntity();
		updateComponents();
	}
	
	protected abstract void updateEntity();
	private void updateComponents(){
		for(Component component : components){
			synchronized (component) {
				component.update();
			}
		}
	}
}
