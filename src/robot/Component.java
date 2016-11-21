package robot;

public abstract class Component {
	protected String name = "Not Set!";
	protected Entity entity;
	public String getName(){
		return name;
	}
	public void setEntity(Entity entity){
		this.entity = entity;
	}
	public abstract void initialize();
	public abstract void update();
}
