
public abstract class Character {
	private WeaponBehavior weapon;
	protected String name;
	protected String description;
	
	public Character() {
		
	}
	public Character(String n) {
		this.name=n;
	}
	public void fight() {
		weapon.useWeapon();
	}
	public void test() {
		Logger.getInstance().info(getName()+" alias "+getDescription());
	}
	public void setWeapon(WeaponBehavior w) {
		this.weapon=w;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the weapon
	 */
	public WeaponBehavior getWeapon() {
		return weapon;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
