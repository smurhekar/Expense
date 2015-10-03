package src;

import java.util.List;

public class Report {

	private List<Expense> expenses;

	public Report(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public String generate() {
		StringBuilder statement = createStatement();
		statement.append("\nTotal = "+totalExpenses());
		return statement.toString();
	}
	
	private StringBuilder createStatement(){
		StringBuilder result = new StringBuilder();
		for(Expense expense: expenses){
			result.append(expense.toString());
			result.append(",");
		}
		removeLastCharacterFrom(result);
		return result;
	}

	private void removeLastCharacterFrom(StringBuilder result) {
		result.deleteCharAt(result.length() - 1);
	}
	
	private int totalExpenses(){
		int total = 0;
		for(Expense expense: expenses){
			total = total + expense.getAmount();
		}
		return total;
	}

}
