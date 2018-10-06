
public class WhiteDecorator extends CharacterDecorator  {
	public WhiteDecorator(Character c) {
		super(c);
	}
	public String getDescription() {
		//add  in white to the current description
		return c.getDescription()+" ... in white";
	}
}
