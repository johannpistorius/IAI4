
public class KnifeBehavior implements WeaponBehavior{

	@Override
	public void useWeapon() {
		Logger.getInstance().warning("I'm using the knife! BEWARE!");
	}
	
}
