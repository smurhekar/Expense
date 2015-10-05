package src;

import java.util.ArrayList;
import java.util.List;

public class Report {

	private final String statement;

	public Report(List<Expense> expenses) {
		List<Expense> expensesAboveLimits = getExpensesAboveLimits(expenses);
		Expense total = totalExpenses(expensesAboveLimits);
		this.statement = statementFor(expensesAboveLimits, total);
		
	}
	
	private String statementFor(List<Expense> expensesAboveLimits, Expense total) {
		StringBuilder result = new StringBuilder();
		for (Expense expense : expensesAboveLimits) {
			result.append(expense).append(",");
		}
		removeLastCharacterFrom(result);
		result.append("\n").append(total);
		return result.toString();
	}

	private Expense totalExpenses(List<Expense> expenses){
		Expense total = new Expense("Total", 0, Integer.MAX_VALUE);
		for (Expense expense : expenses) {
			total = total.add(expense);
		}
		return total;
	}
	
	private List<Expense> getExpensesAboveLimits(List<Expense> expenses){
		List<Expense> expensesAboveLimits = new ArrayList<Expense>();
		for (Expense expense : expenses) {
			if(expense.hasExceededLimit()){
				expensesAboveLimits.add(expense);
			}
		}
		return expensesAboveLimits;
	}

	private void removeLastCharacterFrom(StringBuilder result) {
		result.setLength(result.length() - 1);
	}

	public String toString() {
		return statement;
	}

}
