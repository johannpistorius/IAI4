
public class DarkDecorator extends CharacterDecorator {
	public DarkDecorator(Character c) {
		super(c);
	}
	public String getDescription() {
		//add  in dark to the current description
		return c.getDescription()+" ... in dark";
	}
}
