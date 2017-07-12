
public class Room {
	Room castle = new Room("Castle", null, null, null, null, new String[] { "Sword" });
	String name;
	String north;
	String east;
	String south;
	String west;
	String[] roomInv = new String[15];

	public Room(String Name, String North, String East, String South, String West, String[] RoomInv) {
		name = Name;
		north = North;
		east = East;
		south = South;
		west = West;
		roomInv = RoomInv;
	}
}
