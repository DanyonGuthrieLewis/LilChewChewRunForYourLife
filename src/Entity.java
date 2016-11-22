
import java.util.ArrayList;

import lejos.nxt.Sound;

public abstract class Entity {
	private ArrayList<Component> components = new ArrayList<>();
	private boolean running = true;
	
	public boolean addComponent(Component component){
		if (component == null) return false;
		boolean canAdd = true;
		if (components.size() > 0){

			for (Component existing : components){
				existing.getType();
				component.getType();
				if (existing.getType().equals(component.getType()))
				{
					canAdd = false;
				}
			}
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
			System.out.println(component.getType().toString() + " start");
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
			if (component.getType().equals(name)){
				canRemove = true;
				toRemove = component;
			}
		}
		if (canRemove){
			components.remove(toRemove);
		}
		return canRemove;
	}
	public Component getComponent(ComponentType type){
		Component toGet = null;
		for (Component component : components){
			if (component.getType().equals(type)){
				toGet = component;
				break;
			}
		}
		return toGet;
	}
	
	private void update(){
		updateComponents();
	}
	
	private void updateComponents(){
		for(Component component : components){
			synchronized (component) {
				component.update();
			}
		}
	}
}
