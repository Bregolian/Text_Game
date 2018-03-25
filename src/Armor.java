
public class Armor extends Item{
	int acAddition;
	String name;
	 public Armor(String name, int acAddition, int buyValue, int sellValue) {
		 super(name, buyValue, sellValue);
	 }
	 int getAcAddition() {
		 return acAddition;
	 }
}
