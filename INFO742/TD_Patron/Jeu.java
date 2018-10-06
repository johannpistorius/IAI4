
public class Jeu {

	public static void main(String[] args) {
		Character k=new Knight("Theo");
		Character t=new Troll("Polytech");
		k.setWeapon(new SwordBehavior());
		t.setWeapon(new AxeBehavior());
		//Description for a Knight
		k.test();
		
		k=new DarkDecorator(k);
		k=new WhiteDecorator(k);
		//Description for a Knight with Dark and White Decorator
		k.test();
		
		//Creation of a character by using the factory
		Character d = CharacterFactory.getComputer("King","Dave");
		d.test();
		
		//Adapt a character
		DuckAdapter f = new DuckAdapter(t);
		f.combat();
		
		//Creation for a Duck
		Duck donald = new Duck();
		donald.combat();
	}

}
