package src;

import java.util.List;

public class Report {

	private final String statement;

	public Report(List<Expense> expenses) {
		this.statement = getStatementFor(expenses);
	}

	private String getStatementFor(List<Expense> expenses) {
		StringBuilder result = new StringBuilder();
		Expense total = new Expense("Total", 0, Integer.MAX_VALUE);
		for(Expense expense: expenses){
			if(expense.hasExceededLimit()) {
				result.append(expense).append(",");
				total = total.add(expense);
			}
		}
		result.setLength(result.length() - 1);
		result.append("\n").append(total);
		return result.toString();
	}

	public String toString() {
		return statement;
	}

}
