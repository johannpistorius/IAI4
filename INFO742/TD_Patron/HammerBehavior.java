
public class HammerBehavior implements WeaponBehavior{

	@Override
	public void useWeapon() {
		Logger.getInstance().warning("I'm using the hammer! BEWARE!");
	}
	
}
