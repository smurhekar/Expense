package src;

public class Expense {

	private String type;
	private int amount;
	private int limit;

	public Expense(String type, int amount, int limit) {
		this.type = type;
		this.amount = amount;
		this.limit = limit;
	}
	
	@Override
	public String toString(){
		return type + ": " + amount;
	}

	public int getAmount() {
		return amount;
	}

	public int limit() {
		return limit;
	}

}
