
public class WhiteDecorator extends CharacterDecorator  {
	public WhiteDecorator(Character c) {
		super(c);
	}
	public String getDescription() {
		return c.getDescription()+" ... in white";
	}
}
