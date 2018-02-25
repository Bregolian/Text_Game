
public class Item {
	private int sellValue;
	private int buyValue;

	public Item(int buyValue, int sellvalue) {
		
	}
	int getBuyValue() {
		return buyValue;
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
}
