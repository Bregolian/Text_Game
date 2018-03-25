
public class Monster {
	private String name;
	private int health;
	private Armor armor;
	private Weapon weapon;
	private int gold;
	private int ac;
public Monster(String name, int health, Armor armor, Weapon weapon, int gold, int ac) {
	this.name=name;
	this.health=health;
	this.armor=armor;
	this.weapon=weapon;
	this.gold=gold;
}
public String getName() {
	return name;
}
public int getAC() {
	return ac;
}
public int getGold() {
	return gold;
}
public int getHealth() {
	return health;
}
public Weapon getWeapon() {
	return weapon;
}
public void setHealth(int health) {
	this.health=health;
}
}
