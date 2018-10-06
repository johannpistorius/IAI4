
public class CharacterFactory {
	//We can add others conditions for new roles
	public static Character getComputer(String type, String name){
		if("King".equalsIgnoreCase(type)) return new King(name);
		else if("Knight".equalsIgnoreCase(type)) return new Knight(name);
		else if("Queen".equalsIgnoreCase(type)) return new Queen(name);
		else if("Troll".equalsIgnoreCase(type)) return new Troll(name);
		return null;
	}
}

