
public abstract class CharacterDecorator extends Character {
	
	protected Character c;
	
	public CharacterDecorator(Character c) {
		this.c=c;
	}
	public void setWeapon(WeaponBehavior wp) {
		c.setWeapon(wp);
	}
	public WeaponBehavior getWeapon() {
		return c.getWeapon();
	}
}

