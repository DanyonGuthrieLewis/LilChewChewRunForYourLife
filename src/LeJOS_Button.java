import lejos.nxt.Button;

public class LeJOS_Button implements IButtonSystem{

	private Button button;
	public LeJOS_Button(Button button) {
		this.button = button;
	}
	@Override
	public boolean buttonIsDown() {
		return button.isDown();
	}

}
