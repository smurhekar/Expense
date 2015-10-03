package src;

public class Expense {

	private String type;
	private int amount;

	public Expense(String type, int amount) {
		this.type = type;
		this.amount = amount;
	}
	
	@Override
	public String toString(){
		return type + ": " + amount;
	}

	public int getAmount() {
		return amount;
	}

}
