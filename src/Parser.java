import java.util.ArrayList;

public class Parser {
	String output;
	boolean isFirst = true;
	Inventory i = new Inventory();
	Armor clothArmor = new Armor("Cloth Armor", 1, 10, 0);
	Player player = new Player(Map.getAltar(), i.startItems2, 100, clothArmor);

	public Parser(Player p) {
		player = p;
	}

	String parse(String[] a) {
		if (isFirst) {
			return firstParse(a[0]);
		} else {
			return normalParse(a);
		}
	}

	String firstParse(String input) {
		player.setName(input);
		isFirst = false;
		return "Ok, " + input + ". If you don't know what to do type help for a list of possible commands.";
	}

	String listToSingle(ArrayList<String> z) {
		String converted = "";
		for (int i = 0; i < z.size(); i++) {

			if (i > 0) {
				converted += ", ";
			}
			if (i != 0 && z.size() - 1 == i) {
				converted += "and a ";
			}
			converted += z.get(i);

		}
		if (z.size() != 0) {
			converted += ".";
		}
		return converted;
	}

	String arrayToString(String[] l) {
		String converted = "";
		for (int i = 0; i < l.length; i++) {
			if (i > 0) {
				converted += " ";
			}
			converted += l[i];

		}
		return converted;
	}

	String normalParse(String[] a) {
		if (a[0].equals("i") || a[0].equals("inventory")) {
			return "In your inventory you have " + player.getEquippedName() + " equipped, and "
					+ player.inventory2.getInventory() + player.inventory2.getMoney() + " gold pieces.";
		} else if (a[0].equalsIgnoreCase("Take")) {
			return "Come on do something understandable!";
		} else if (a[0].equalsIgnoreCase("Drop")) {
			if (a[1] != null && player.inventory2.findItem(a[1]) > -1) {
				player.inventory2.deleteItem(player.inventory2.findItem(a[1]));
				return "You dropped your " + a[1] + ".";
			} else {
				return "You don't have this item!";
			}
		} else if (a[0].equalsIgnoreCase("Fight") || a[0].equalsIgnoreCase("Attack") || a[0].equalsIgnoreCase("Kill")) {
			if (a.length > 1) {
				if (player.location.checkMonster(player.location, a[1])) {
					if (player.checkWeapon(player, a[3])) {
						return player.fight(player, player.location.findMonster(player.location, a[1]), player.findWeapon(player, a[3]));
					}
					return "You dont have that weapon.";
				} else {
					return "There is no " + a[1] + " here.";
				}
			} else {
				return "What?";
			}
		} else if (a[0].equalsIgnoreCase("help")) {
			return "To move around simply say the direction you would like to go ie \"north, south, east, west\" To see your inventory"
					+ " type inventory or i. If you want to examine the area around you for hidden items say search. Alternatively to just"
					+ " examine your surrounding say look. To retrieve items you have seen say take and then say the item ie \"take berries\"."
					+ " If for any reason you want to put something to it's rightful place. *wink* Say return and then whatever you want to return."
					+ " The rest of the commands are secret good luck finding them all. " + "\nSincerely,"
					+ "\n               Your Friendly Neighborhood Parser";
		} else if (a[0].equalsIgnoreCase("S") || a[0].equalsIgnoreCase("Score")) {

			return "Your score is " + player.inventory2.getScore() + ".";
		} else if (a[0].equalsIgnoreCase("Go") || a[0].equalsIgnoreCase("Travel")) {

			return player.move(a[1]);
		} else if (a[0].equalsIgnoreCase("east") || a[0].equalsIgnoreCase("north") || a[0].equalsIgnoreCase("south")
				|| a[0].equalsIgnoreCase("west")) {
			return player.move(a[0]);
		} else if (a[0].equalsIgnoreCase("look")) {

			return player.location.readDesc();
		} else if (a[0].equalsIgnoreCase("search")) {
			ArrayList<String> found = player.location.search(player.location, player);
			String foundString;
			System.out.println(listToSingle(found));
			if (listToSingle(found).equals("")) {
				return "You didn't find anything.";
			} else {
				foundString = "You found " + listToSingle(found);
				return foundString;
			}
		} else {
			return "Come on do something understandable!";

		}
	}
}
