import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
	Room location;
	ArrayList<Item> inventory;
	Inventory inventory2 = new Inventory();
	String name;
	int health;
	Armor equipped;

	public Player(Room startingPos, ArrayList<Item> startInventory, int startHealth, Armor equipped) {
		location = startingPos;
		inventory = startInventory;
		health = startHealth;
		this.equipped = equipped;
	}

	public boolean checkWeapon(Player p, String weapon) {
		for (int i = 0; i < p.inventory.size(); i++) {
			if (p.inventory.get(i).getName().equals(weapon)) {
				return true;
			}
		}
		return false;
	}

	public Item findWeapon(Player p, String name) {
		for (int i = 0; i < p.inventory.size(); i++) {
			if (p.inventory.get(i).getName().equals(name)) {
				return p.inventory.get(i);
			}
		}
		return null;

	}

	public int getAC() {
		return 12 + equipped.getAcAddition();
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Armor getEquipped() {
		return equipped;
	}

	public String fight(Player p, Monster enemy, Item weapon) {
		int d20Attack = ThreadLocalRandom.current().nextInt(20) + 1;
		int baseDmg;
		int extraDmg;
		int dmg;
		int enemyD20Attack;
		int enemyBaseDmg;
		int enemyExtraDmg;
		int enemyDmg;
		if (d20Attack == 20) {
			baseDmg = ThreadLocalRandom.current().nextInt(8) + 1;
			extraDmg = ThreadLocalRandom.current().nextInt(8) + 1;
			dmg = baseDmg + weapon.getDmgBonus() + extraDmg + weapon.getDmgBonus();
			enemy.setHealth(enemy.getHealth() - dmg);
			if (enemy.getHealth() == 0 || enemy.getHealth() < 0) {
				p.inventory2.money = p.inventory2.money + enemy.getGold();
				p.location.monsterInv.remove(p.location.findMonster(p.location, enemy.getName()));
				return "You defeated the " + enemy.getName() + " with a critical hit. You looted " + enemy.getGold()
						+ " gold pieces from the " + enemy.getName();
			} else {
				enemyD20Attack = ThreadLocalRandom.current().nextInt(20) + 1;
				if (enemyD20Attack == 20) {
					enemyBaseDmg = ThreadLocalRandom.current().nextInt(8) + 1;
					enemyExtraDmg = ThreadLocalRandom.current().nextInt(8) + 1;
					enemyDmg = enemyBaseDmg + enemy.getWeapon().getDmgBonus() + enemyExtraDmg
							+ enemy.getWeapon().getDmgBonus();
					p.setHealth(p.getHealth() - enemyDmg);
					if (p.getHealth() == 0 || p.getHealth() < 0) {
						p.location = Map.startAltar;
						p.setHealth(100);
						return "You landed a critical hit and dealt " + dmg + " points of damage. When the "
								+ enemy.getName() + " attacked it landed a critical hit and dealt " + enemyDmg
								+ " points of damage. You died. You wake up to a bright light.";
					}
					return "You landed a critical hit and dealt " + dmg + " points of damage. When the "
							+ enemy.getName() + " attacked it landed a critical hit and dealt " + enemyDmg
							+ " points of damage.";
				} else if (enemyD20Attack + enemy.getWeapon().getHitBonus() > p.getAC()) {
					enemyBaseDmg = ThreadLocalRandom.current().nextInt(8) + 1;
					enemyDmg = enemyBaseDmg + weapon.getDmgBonus();
					p.setHealth(p.getHealth() - enemyDmg);
					if (p.getHealth() == 0 || p.getHealth() < 0) {
						p.location = Map.startAltar;
						p.setHealth(100);
						return "You landed a critical hit and dealt " + dmg + " points of damage. When the "
								+ enemy.getName() + " attacked it landed a critical hit and dealt " + enemyDmg
								+ " points of damage. You died. You wake up to a bright light.";
					}
					return "You landed a critical hit and dealt " + dmg + " points of damage. When the "
							+ enemy.getName() + " attacked it dealt " + enemyDmg + " points of damage.";
				} else {
					return "You landed a critical hit and dealt " + dmg + " points of damage. When the "
							+ enemy.getName() + " attacked it missed.";
				}
			}
		} else if (d20Attack + weapon.getHitBonus() > enemy.getAC()) {
			baseDmg = ThreadLocalRandom.current().nextInt(8) + 1;
			dmg = baseDmg + weapon.getDmgBonus();
			enemy.setHealth(enemy.getHealth() - dmg);
			if (enemy.getHealth() == 0 || enemy.getHealth() < 0) {
				return "You defeated the " + enemy.getName() + ".";
			} else {
				enemyD20Attack = ThreadLocalRandom.current().nextInt(20) + 1;
				if (enemyD20Attack == 20) {
					enemyBaseDmg = ThreadLocalRandom.current().nextInt(8) + 1;
					enemyExtraDmg = ThreadLocalRandom.current().nextInt(8) + 1;
					enemyDmg = enemyBaseDmg + enemy.getWeapon().getDmgBonus() + enemyExtraDmg
							+ enemy.getWeapon().getDmgBonus();
					p.setHealth(p.getHealth() - enemyDmg);
					if (p.getHealth() == 0 || p.getHealth() < 0) {
						p.location = Map.startAltar;
						p.setHealth(100);
						return "You hit the " + enemy.getName()+" and dealt " + dmg + " points of damage. When the "
								+ enemy.getName() + " attacked it landed a critical hit and dealt " + enemyDmg
								+ " points of damage. You died. You wake up to a bright light.";
					}
					return "You hit the " + enemy.getName()+" and dealt " + dmg + " points of damage. When the "
							+ enemy.getName() + " attacked it landed a critical hit and dealt " + enemyDmg
							+ " points of damage.";
				} else if (enemyD20Attack + enemy.getWeapon().getHitBonus() > p.getAC()) {
					enemyBaseDmg = ThreadLocalRandom.current().nextInt(8) + 1;
					enemyDmg = enemyBaseDmg + weapon.getDmgBonus();
					p.setHealth(p.getHealth() - enemyDmg);
					if (p.getHealth() == 0 || p.getHealth() < 0) {
						p.location = Map.startAltar;
						p.setHealth(100);
						return "You hit the " + enemy.getName()+" and dealt " + dmg + " points of damage. When the "
								+ enemy.getName() + " attacked it landed a critical hit and dealt " + enemyDmg
								+ " points of damage. You died. You wake up to a bright light.";
					}
					return "You hit the " + enemy.getName()+" and dealt " + dmg + " points of damage. When the "
							+ enemy.getName() + " attacked it dealt " + enemyDmg + " points of damage.";
				} else {
					return "You hit the " + enemy.getName()+" and dealt " + dmg + " points of damage. When the "
							+ enemy.getName() + " attacked it missed.";
				}
			}
		} else {
			return "You didn't hit the " + enemy.getName() + ".";
		}
	}

	public Room getLocation() {
		return location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEquippedName() {
		return equipped.getName();
	}

	public String move(String direction) {
		if (direction.equalsIgnoreCase("north")) {
			System.out.println(location.name);
			if (location.getNorth() != null) {
				location = location.getNorth();
				return location.readDesc();
			} else {
				return "You can't go north.";
			}
		} else if (direction.equalsIgnoreCase("east")) {
			if (location.getEast() != null) {
				location = location.getEast();
				return location.readDesc();
			} else {
				return "You can't go east.";
			}
		} else if (direction.equalsIgnoreCase("south")) {
			if (location.getSouth() != null) {
				location = location.getSouth();
				return location.readDesc();
			} else {
				return "You can't go south.";
			}
		} else if (direction.equalsIgnoreCase("west")) {
			if (location.getWest() != null) {
				location = location.getWest();
				return location.readDesc();
			} else {
				return "You can't go west.";
			}
		} else {
			return "That's not a valid command.";
		}

	}

}
