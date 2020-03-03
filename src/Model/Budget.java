package Model;

public class Budget {
	private String Item;
	private int Number;
	private int Cost;
	
	public Budget(String i, int n, int c) {
		Item = i;
		Number = n;
		Cost = c;
	}
	
	public String getItem() {
		return Item;
	}
	
	public int getNumber() {
		return Number;
	}
	
	public int getCost() {
		return Cost;
	}
}
