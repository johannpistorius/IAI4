
public class BowAndArrowBehavior implements WeaponBehavior{

	@Override
	public void useWeapon() {
		Logger.getInstance().warning("I'm using the bow and arrow! BEWARE!");
	}
	
}
