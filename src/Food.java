
public class Food extends Item{
	int healthBoost;
	String name;
	 public Food(String name, int healthBoost, int buyValue, int sellValue) {
		 super(name, buyValue, sellValue);
		 this.healthBoost=healthBoost;
		 this.name=name;
	 }
	 
}
