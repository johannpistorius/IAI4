
public class SwordBehavior implements WeaponBehavior{

	@Override
	public void useWeapon() {
		Logger.getInstance().warning("I'm using the sword! BEWARE!");
	}
	
}
