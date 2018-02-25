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
	ArrayList<Item> roomInv2= new ArrayList <Item>();;
	public Room() {
	}

	public Room(String Name, Room North, Room East, Room South, Room West, String[] RoomInv, ArrayList<Item> roomInv2) {
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

	public void setFields(String Name, Room North, Room East, Room South, Room West, String[] RoomInv, ArrayList<Item> RoomInv2) {
		name = Name;
		north = North;
		east = East;
		south = South;
		west = West;
		roomInv = RoomInv;
		roomInv2 = RoomInv2;
	}

	public String readDesc() {
		return name;
	}

	public ArrayList<String> search(Room r) {
		ArrayList<String> found = new ArrayList<>();
		int d20 = ThreadLocalRandom.current().nextInt(20) + 1;
		if (r.roomInv.length > 0) {
			if (d20 > 5) {
				found.add(r.roomInv[0]);
			}
		}
		if (r.roomInv.length > 1) {
			if (d20 > 10) {
				found.add(r.roomInv[1]);
			}
		}
		if (r.roomInv.length > 2) {
			if (d20 > 15) {
				found.add(r.roomInv[2]);
			}
		}
		if (r.roomInv.length > 3) {
			if (d20 > 19) {
				found.add(r.roomInv[3]);
			}
		}
		return found;

	}
}
