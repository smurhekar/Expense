package src;

public class Expense {

	private final String title;
	private final int amount;
	private final int limit;

	public Expense(String title, int amount, int limit) {
		this.title = title;
		this.amount = amount;
		this.limit = limit;
	}
	
	@Override
	public String toString(){
		return title + ": " + amount;
	}

	public boolean hasExceededLimit(){
		return amount > limit;
	}

	public Expense add(Expense thatExpense) {
		int newAmount = this.amount + thatExpense.amount;
		return new Expense(this.title, newAmount, this.limit);
	}
}
