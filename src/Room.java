
public class Room {
	String name;
	Room north;
	Room east;
	Room south;
	Room west;
	String[] roomInv = new String[15];

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

	public String readDesc() {
		return name;
	}

}
