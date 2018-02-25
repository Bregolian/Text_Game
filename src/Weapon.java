
public class Weapon extends Item{
	int hitBonus;
	int dmgBonus;
	String name;
	 public Weapon( String name, int hitBonus, int dmgBonus, int buyValue, int sellValue) {
		 super(buyValue, sellValue);
	 }
}
