
public class Player {
	Room location;

	public Player(Room startingPos) {
		location = startingPos;
	}

	public Room getLocation() {
		return location;
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
