
public class Parser {
	String output;
	boolean isFirst = true;
	Inventory inventory = new Inventory();

	public Parser() {

	}

	String parse(String[] a) {
		if (isFirst) {
			inventory.setName(a[0]);
			isFirst = false;
			return "Ok, " + a[0];
		} else {
			if (a[0].equals("i") || a[0].equals("inventory")) {
				output = "In your inventory you have " + inventory.getInventory() + inventory.getMoney() + " gold pieces.";
				return output;
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
			} else {
				return "Come on do something understandable!";

			}
		}

	}
}
