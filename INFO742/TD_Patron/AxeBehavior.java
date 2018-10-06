
public class AxeBehavior implements WeaponBehavior{

	@Override
	public void useWeapon() {
		Logger.getInstance().warning("I'm using the axe! BEWARE!");
	}
	
}
