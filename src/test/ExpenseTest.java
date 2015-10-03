package test;

import org.junit.Test;
import src.Expense;
import src.Report;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ExpenseTest {
	
	@Test
	public void shouldBeAbleToCreateExpense(){
		Expense expense = new Expense("Car", 2000, 0);
		assertEquals("Car: 2000", expense.toString());
	}
	
	@Test
	public void shouldBeAbleToAddExpenseByType(){
		Expense dinner = new Expense("Dinner", 1000, 0);
		Report report = new Report(Arrays.asList(dinner));
		assertEquals("Dinner: 1000\n" +
				     "Total: 1000", report.toString());
	}

	@Test
	public void shouldBeAbleToAddMultipleExpensesByType(){
		Expense dinner = new Expense("Dinner", 1000, 0);
		Expense car = new Expense("Car", 2000, 0);
		Report report = new Report(Arrays.asList(dinner, car));
		assertEquals("Dinner: 1000\n" +
				     "Car: 2000\n" +
				     "Total: 3000", report.toString());
	}
	
	@Test
	public void shouldBeAbleToTotalAddedExpenses(){
		Expense dinner = new Expense("Dinner", 1000, 0);
		Expense car = new Expense("Car", 2000, 0);
		Report report = new Report(Arrays.asList(dinner, car));
		assertEquals("Dinner: 1000\n" +
				     "Car: 2000\n" +
				     "Total: 3000", report.toString());
	}
	
	@Test
	public void shouldTotalExpensesWhichAreAboveSpecifiedLimit(){
		Expense dinner = new Expense("Dinner", 1500, 1000);
		Expense car = new Expense("Car", 2000, 1000);
		Expense Laundry = new Expense("Laundry", 500, 1000);
		Report report = new Report(Arrays.asList(dinner, car, Laundry));
		assertEquals("Dinner: 1500\n" +
				     "Car: 2000\n" +
				     "Total: 3500", report.toString());
	}

}
