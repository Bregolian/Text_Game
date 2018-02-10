import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.tools.DocumentationTool.Location;

public class Room {
	String name;
	Room north;
	Room east;
	Room south;
	Room west;
	String[] roomInv = new String[0];

	public Room() {
	}

	public Room(String Name, Room North, Room East, Room South, Room West, String[] RoomInv) {
		name = Name;
		north = North;
		east = East;
		south = South;
		west = West;
		roomInv = RoomInv;
	}

	public Room getNorth() {
		return north;
	}

	public Room getEast() {
		return east;
	}

	public Room getSouth() {
		return south;
	}

	public Room getWest() {
		return west;
	}

	public void setFields(String Name, Room North, Room East, Room South, Room West, String[] RoomInv) {
		name = Name;
		north = North;
		east = East;
		south = South;
		west = West;
		roomInv = RoomInv;
	}

	public String readDesc() {
		return name;
	}

	public ArrayList<String> search() {
		ArrayList<String> found = new ArrayList<>();
		int d20 = ThreadLocalRandom.current().nextInt(20) + 1;
		if (roomInv.length > 0) {
			if (d20 > 5) {
				found.add(roomInv[0]);
			}
		}
		if (roomInv.length > 1) {
			if (d20 > 10) {
				found.add(roomInv[1]);
			}
		}
		return found;

	}
}
