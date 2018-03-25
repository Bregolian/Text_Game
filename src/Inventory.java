import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {
	int money = 0;
	int score = 0;
	
	ArrayList<String> items;
	ArrayList<String> startItems=items;
	Armor clothArmor =new Armor("Cloth Armor", 1, 10, 0);
	Weapon rustyShortSword = new Weapon("Rusty Short-Sword", 2, 4, 30, 15);
	ArrayList<Item> startItems2=new ArrayList<Item> (Arrays.asList(clothArmor, rustyShortSword));
	public Inventory() {

	}
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public ArrayList<String> getItems() {
		return items;
	}

	public ArrayList<String> getInventory() {
		ArrayList<String> finalWord= new ArrayList<String>();
		
			for (String s:items) {
				finalWord.add(s);
			}
		
		return finalWord;
	}

	public int findItem(String item) {
		int itemLocation = -1;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) != null && items.get(i).equalsIgnoreCase(item)) {
				itemLocation = i;
			}
		}
		return itemLocation;
	}

	public String deleteItem(int location) {
		String removedItem;
		removedItem = items.get(location);
		items.remove(items.get(location)) ;
		return removedItem;
	}

	public void setItem(String item, int location) {
		items.add(item) ;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
