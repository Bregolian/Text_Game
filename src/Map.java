
public class Map {
	Room northwesternForest=new Room();
	Room southwesternForest=new Room();
	Room northeasternForest=new Room();
	Room southeasternForest=new Room();
	Room westernCanyon=new Room();
	Room easternCanyon=new Room();
	Room altar=new Room();
	Room nsRoadOne=new Room();
	Room nsRoadTwo=new Room();
	Room easternField=new Room();
	Room westernField=new Room();
	Room crossroads=new Room();
	Room ewRoadOne=new Room();
	Room ewRoadTwo=new Room();
	Room bridge=new Room();
	Room river=new Room();
	Room commonQuarter=new Room();
	Room merchantQuarter=new Room();
	Room magicQuarter=new Room();
	Room nobleQuarter=new Room();
	Room forestTempleEntry=new Room();
	Room canyonTempleEntry=new Room();
	Room waterTempleEntry=new Room();
	Room swamp=new Room();
	Room plague=new Room();
	Room guardHouse=new Room();
	
	void setUp() {
		northwesternForest.setFields("Forest", westernField, nsRoadOne, southwesternForest, forestTempleEntry,
				new String[] { "Berries", "Squirrel", "Deer" });
		southwesternForest.setFields("Forest", northwesternForest, altar, westernCanyon, forestTempleEntry, new String[] { "Berries", "Squirrel", "Deer" });
		northeasternForest.setFields("Forest", easternField, forestTempleEntry, southeasternForest, nsRoadOne,
				new String[] { "Berries", "Squirrel", "Deer" });
		southeasternForest.setFields("Forest", northeasternForest, forestTempleEntry, easternCanyon, altar, new String[] { "Berries", "Squirrel", "Deer" });
		westernCanyon.setFields("Canyon", southwesternForest, canyonTempleEntry, null, easternCanyon, new String[] {});
		easternCanyon.setFields("Canyon", southeasternForest, westernCanyon, null, canyonTempleEntry, new String[] {});
		altar.setFields("Altar of the Gods", nsRoadOne, southeasternForest, null, southwesternForest, new String[] {});
		nsRoadOne.setFields("North/South King's Road", nsRoadTwo, northeasternForest, altar, northwesternForest, new String[] {});
		nsRoadTwo.setFields("North/South King's Road", crossroads, easternField, nsRoadOne, westernField, new String[] {});
		easternField.setFields("Field", null, westernField, northeasternForest, nsRoadTwo, new String[] { "Corn" });
		westernField.setFields("Field", null, nsRoadTwo, northwesternForest, easternField, new String[] { "Corn" });
		crossroads.setFields("King's Cross", commonQuarter, ewRoadTwo, nsRoadTwo, ewRoadOne, new String[] {});
		ewRoadOne.setFields("East/West King's Road", null, crossroads, null, crossroads, new String[] {});
		ewRoadTwo.setFields("East/West King's Road", null, swamp, null, crossroads, new String[] {});
		bridge.setFields("River Bridge", null, ewRoadOne, river, plague, new String[] {});
		river.setFields("River", bridge, null, waterTempleEntry, null, new String[] {});
		commonQuarter.setFields("Common Quarter", nobleQuarter, magicQuarter, crossroads, merchantQuarter, new String[] {});
		merchantQuarter.setFields("Merchant's Quarter", nobleQuarter, magicQuarter, commonQuarter, null, new String[] {});
		magicQuarter.setFields("Arcane Quarter", nobleQuarter, null, commonQuarter, magicQuarter, new String[] {});
		nobleQuarter.setFields("Noble Quarter", guardHouse, magicQuarter, commonQuarter, merchantQuarter, new String[] {});
		forestTempleEntry.setFields("Forest Temple", null, northwesternForest, null, northeasternForest, new String[] {});
		canyonTempleEntry.setFields("Canyon Temple", null, easternCanyon, null, westernCanyon, new String[] {});
		waterTempleEntry.setFields("Water Temple", river, null, null, null, new String[] {});
	}
}
