package src;

import java.util.List;

public class Report {

	private final String statement;

	public Report(List<Expense> expenses) {
		StringBuilder result = new StringBuilder();
		Expense total = new Expense("Total", 0, Integer.MAX_VALUE);
		for(Expense expense: expenses){
			if(expense.hasExceededLimit()) {
				result.append(expense).append(",");
				total = total.add(expense);
			}
		}
		result.setLength(result.length() - 1);
		this.statement = result.append("\n").append(total).toString();
	}

	public String toString() {
		return statement;
	}

}
