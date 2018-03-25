import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Room {
	String name;
	Room north;
	Room east;
	Room south;
	Room west;
	ArrayList<Item> roomInv = new ArrayList<Item>();
	ArrayList<Monster> monsterInv = new ArrayList<Monster>();

	public Room() {
	}

	public Room(String Name, Room North, Room East, Room South, Room West, ArrayList<Item> RoomInv,
			ArrayList<Monster> MonsterInv) {
		name = Name;
		north = North;
		east = East;
		south = South;
		west = West;
		roomInv = RoomInv;
		monsterInv = MonsterInv;
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

	public void setFields(String Name, Room North, Room East, Room South, Room West, ArrayList<Item> RoomInv,
			ArrayList<Monster> MonsterInv) {
		name = Name;
		north = North;
		east = East;
		south = South;
		west = West;
		roomInv = RoomInv;
		monsterInv = MonsterInv;
	}

	public String readDesc() {
		return name;
	}

	public boolean checkMonster(Room r, String monster) {
		for (int i = 0; i < r.monsterInv.size(); i++) {
			if (r.monsterInv.get(i).getName().equals(monster)) {
				return true;
			}
		}
		return false;
	}
	public Monster findMonster(Room r, String monster) {
		for (int i = 0; i < r.monsterInv.size(); i++) {
			if (r.monsterInv.get(i).getName().equals(monster)) {
				return r.monsterInv.get(i);
			}
		}
		return null;
	}
	public ArrayList<String> search(Room r, Player p) {
		ArrayList<String> found = new ArrayList<>();
		int d20 = ThreadLocalRandom.current().nextInt(20) + 1;
		if (r.roomInv.size() > 0) {
			if (d20 > 5) {
				found.add(r.roomInv.get(0).getName());
				p.inventory.add(r.roomInv.get(0));
				r.roomInv.remove(0);
			}
		}
		if (r.roomInv.size() > 1) {
			if (d20 > 10) {
				found.add(r.roomInv.get(1).getName());
				p.inventory.add(r.roomInv.get(1));
				r.roomInv.remove(1);
			}
		}
		if (r.roomInv.size() > 2) {
			if (d20 > 15) {
				found.add(r.roomInv.get(2).getName());
				p.inventory.add(r.roomInv.get(2));
				r.roomInv.remove(2);
			}
		}
		if (r.roomInv.size() > 3) {
			if (d20 > 19) {
				found.add(r.roomInv.get(3).getName());
				p.inventory.add(r.roomInv.get(3));
				r.roomInv.remove(3);
			}
		}
		if (r.roomInv.size() > 4) {
			for (int i = 4; i < roomInv.size(); i++) {
				found.add(r.roomInv.get(i).getName());
				p.inventory.add(r.roomInv.get(i));
				r.roomInv.remove(i);
			}
		}
		return found;
	}

}
