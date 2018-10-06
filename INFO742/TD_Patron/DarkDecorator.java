
public class DarkDecorator extends CharacterDecorator {
	public DarkDecorator(Character c) {
		super(c);
	}
	public String getDescription() {
		return c.getDescription()+" ... in dark";
	}
}
