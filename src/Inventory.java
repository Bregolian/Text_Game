
public class Inventory {
	int money = 0;
	int score = 0;
	String name = "";
	String[] items = new String[20];

	public Inventory() {

	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String[] getItems() {
		return items;
	}

	public String getInventory() {
		String finalWord = "";
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				finalWord += items[i] + ", ";
			}
		}
		return finalWord;
	}

	public int findItem(String item) {
		int itemLocation = -1;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null && items[i].equalsIgnoreCase(item)) {
				itemLocation = i;
			}
		}
		return itemLocation;
	}

	public String deleteItem(int location) {
		String removedItem;
		removedItem = items[location];
		items[location] = null;
		return removedItem;
	}

	public void setItem(String item, int location) {
		items[location] = item;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
