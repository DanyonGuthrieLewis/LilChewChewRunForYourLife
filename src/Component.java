
public abstract class Component {
	protected Entity entity;
	
	public void setEntity(Entity entity){
		this.entity = entity;
	}
	public abstract void initialize();
	public abstract void start();
	public abstract void update();
	public abstract ComponentType getType();
}
