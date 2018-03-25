
public class Weapon extends Item{
	int hitBonus;
	int dmgBonus;
	String name;
	 public Weapon( String name, int hitBonus, int dmgBonus, int buyValue, int sellValue) {
		 super(name, buyValue, sellValue);
		 this.dmgBonus=dmgBonus;
		 this.hitBonus=hitBonus;
		 this.name=name;
	 }
	 public int getHitBonus() {
		return hitBonus;
		 
	 }
	 public int getDmgBonus() {
			return dmgBonus;
			 
		 }
}
