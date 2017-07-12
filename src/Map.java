
public class Map {
	Room castle = new Room("Castle", null, null, null, null, new String[] { "Sword" });
	Room northwesternForest = new Room("Forest", "westernField", "nsRoadOne", "southwesternForest", "forestTempleNorthEasternOutside",
			new String[] { "Berries", "Squirrel", "Deer" });
	Room southwesternForest = new Room("Forest", "northwesternForest", "altar", "westernCanyon", "forestTempleSouthEasternOutside", new String[] { "Berries", "Squirrel", "Deer" });
	Room northeasternForest = new Room("Forest", "easternField", "forestTempleNorthWesternOutside", "southeasternForest", "nsRoadOne",
			new String[] { "Berries", "Squirrel", "Deer" });
	Room southeasternForest = new Room("Forest", "northeasternForest", "forestTempleSouthWesternOutside", "easternCanyon", "altar", new String[] { "Berries", "Squirrel", "Deer" });
	Room westernCanyon = new Room("Canyon", "southwesternForest", "canyonTempleWesternOutside", null, "easternCanyon", new String[] { "" });
	Room easternCanyon = new Room("Canyon", "southeasternForest", "westernCanyon", null, "canyonTempleEasternOutside", new String[] { "" });
	Room alter = new Room("Alter of the Gods", "nsRoadOne", "southeasternForest", null, "southwesternForest", new String[] { "" });
	Room nsRoadOne = new Room("North/South King's Road", "nsRoadTwo", "northeasternForest", "altar", "northwesternForest", new String[] { "" });
	Room nsRoadTwo = new Room("North/South King's Road", "nsRoadThree", "easternField", "nsRoadOne", "westernField", new String[] { "" });
	Room easternField = new Room("Field", null, "westernField", "northeasternForest", "nsRoadTwo", new String[] { "Corn" });
	Room westernField = new Room("Field", null, "nsRoadTwo", "northwesternForest", "easternField", new String[] { "Corn" });
	Room nsRoadThree = new Room("North/South King's Road", "nsRoadThree", "easternField", "nsRoadOne", "westernField", new String[] { "" });
}
