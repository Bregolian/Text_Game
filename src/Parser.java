
public class Parser {
	String output;
	boolean isFirst = true;
	Inventory inventory = new Inventory();
	Player player;

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
		inventory.setName(input);
		isFirst = false;
		return "Ok, " + input + ".";
	}

	String normalParse(String[] a) {
		if (a[0].equals("i") || a[0].equals("inventory")) {
			return "In your inventory you have " + inventory.getInventory() + inventory.getMoney() + " gold pieces.";
		} else if (a[0].equalsIgnoreCase("Take")) {
			return "Come on do something understandable!";
		} else if (a[0].equalsIgnoreCase("Drop")) {
			if (a[1] != null && inventory.findItem(a[1]) > -1) {
				inventory.deleteItem(inventory.findItem(a[1]));
				return "You dropped your " + a[1] + ".";
			} else {
				return "You don't have this item!";
			}
		} else if (a[0].equalsIgnoreCase("Fight") || a[0].equalsIgnoreCase("Attack") || a[0].equalsIgnoreCase("Kill")) {
			return "There is no " + a[2] + " here.";
		} else if (a[0].equalsIgnoreCase("S") || a[0].equalsIgnoreCase("Score")) {

			return "Your score is " + inventory.getScore() + ".";
		} else if (a[0].equalsIgnoreCase("Go") || a[0].equalsIgnoreCase("Travel")) {

			return player.move(a[1]);
		//} else if (a[0].equalsIgnoreCase("look")) {
//
		//	return location.readDesc();
		}else {
			return "Come on do something understandable!";

		}
	}
}
