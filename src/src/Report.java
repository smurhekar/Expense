package src;

import java.util.List;

public class Report {

	private List<Expense> expenses;

	public Report(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public String generate() {
		return createStatement().toString();
	}
	
	private StringBuilder createStatement(){
		StringBuilder result = new StringBuilder();
		for(Expense expense: expenses){
			if(expense.hasExceededLimit()){
				result.append(expense.toString());
				result.append(",");
			}
		}
		result.append(totalExpenses());
		return result;
	}

	private Expense totalExpenses(){
		Expense total = new Expense("Total", 0, Integer.MAX_VALUE);
		for(Expense expense: expenses){
			if(expense.hasExceededLimit())
				total = total.add(expense);
		}
		return total;
	}

}
