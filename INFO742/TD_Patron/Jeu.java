
public class Jeu {

	public static void main(String[] args) {
		Character k=new Knight("Theo");
		Character t=new Troll("Polytech");
		k.setWeapon(new SwordBehavior());
		t.setWeapon(new AxeBehavior());
		k.test();
		//t.test();
		//k.fight();
		//t.fight();
		k=new DarkDecorator(k);
		k=new WhiteDecorator(k);
		k.test();
		Character d = CharacterFactory.getComputer("King","Dave");
		d.test();
		DuckAdapter f = new DuckAdapter(t);
		f.combat();
		Duck donald = new Duck();
		donald.combat();
	}

}
