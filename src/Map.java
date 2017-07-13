
public class Map {
	Room northwesternForest;
	Room southwesternForest;
	Room northeasternForest;
	Room southeasternForest;
	Room westernCanyon;
	Room easternCanyon;
	Room altar;
	Room nsRoadOne;
	Room nsRoadTwo;
	Room easternField;
	Room westernField;
	Room crossroads;
	Room ewRoadOne;
	Room ewRoadTwo;
	Room bridge;
	Room river;
	Room commonQuarter;
	Room merchantQuarter;
	Room magicQuarter;
	Room nobleQuarter;
	Room forestTempleEntry;
	Room canyonTempleEntry;
	Room waterTempleEntry;
	Room swamp;
	Room plague;
	Room guardHouse;

	void setUp() {
		northwesternForest = new Room("Forest", westernField, nsRoadOne, southwesternForest, forestTempleEntry,
				new String[] { "Berries", "Squirrel", "Deer" });
		southwesternForest = new Room("Forest", northwesternForest, altar, westernCanyon, forestTempleEntry, new String[] { "Berries", "Squirrel", "Deer" });
		northeasternForest = new Room("Forest", easternField, forestTempleEntry, southeasternForest, nsRoadOne,
				new String[] { "Berries", "Squirrel", "Deer" });
		southeasternForest = new Room("Forest", northeasternForest, forestTempleEntry, easternCanyon, altar, new String[] { "Berries", "Squirrel", "Deer" });
		westernCanyon = new Room("Canyon", southwesternForest, canyonTempleEntry, null, easternCanyon, new String[] {});
		easternCanyon = new Room("Canyon", southeasternForest, westernCanyon, null, canyonTempleEntry, new String[] {});
		altar = new Room("Altar of the Gods", nsRoadOne, southeasternForest, null, southwesternForest, new String[] {});
		nsRoadOne = new Room("North/South King's Road", nsRoadTwo, northeasternForest, altar, northwesternForest, new String[] {});
		nsRoadTwo = new Room("North/South King's Road", crossroads, easternField, nsRoadOne, westernField, new String[] {});
		easternField = new Room("Field", null, westernField, northeasternForest, nsRoadTwo, new String[] { "Corn" });
		westernField = new Room("Field", null, nsRoadTwo, northwesternForest, easternField, new String[] { "Corn" });
		crossroads = new Room("King's Cross", commonQuarter, ewRoadTwo, nsRoadTwo, ewRoadOne, new String[] {});
		ewRoadOne = new Room("East/West King's Road", null, crossroads, null, crossroads, new String[] {});
		ewRoadTwo = new Room("East/West King's Road", null, swamp, null, crossroads, new String[] {});
		bridge = new Room("River Bridge", null, ewRoadOne, river, plague, new String[] {});
		river = new Room("River", bridge, null, waterTempleEntry, null, new String[] {});
		commonQuarter = new Room("Common Quarter", nobleQuarter, magicQuarter, crossroads, merchantQuarter, new String[] {});
		merchantQuarter = new Room("Merchant's Quarter", nobleQuarter, magicQuarter, commonQuarter, null, new String[] {});
		magicQuarter = new Room("Arcane Quarter", nobleQuarter, null, commonQuarter, magicQuarter, new String[] {});
		nobleQuarter = new Room("Noble Quarter", guardHouse, magicQuarter, commonQuarter, merchantQuarter, new String[] {});
		forestTempleEntry = new Room("Forest Temple", null, northwesternForest, null, northeasternForest, new String[] {});
		canyonTempleEntry = new Room("Canyon Temple", null, easternCanyon, null, westernCanyon, new String[] {});
		waterTempleEntry = new Room("Water Temple", river, null, null, null, new String[] {});
	}
}
