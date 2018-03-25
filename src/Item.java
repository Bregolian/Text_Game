
public class Item {
	private int sellValue;
	private int buyValue;
	private String name;
	public Item(String name, int buyValue, int sellValue) {
		this.name=name;
		this.buyValue=buyValue;
		this.sellValue=sellValue;
	}
	int getBuyValue() {
		return buyValue;
	}
	int getHitBonus() {
		return getHitBonus();
	}
	int getDmgBonus() {
		return getDmgBonus();
	}
	int getAcAddition() {
		return getAcAddition();
	}
	int getSellValue() {
		return sellValue;
	}
	void setSellValue(int sellValue) {
		this.sellValue=sellValue;
	}
	void setBuyValue(int buyValue) {
		this.buyValue=buyValue;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name=name;
	}
}
