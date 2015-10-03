package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import src.Account;
import src.Expense;
import src.Report;

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
		assertEquals("Dinner: 1000\nTotal = 1000", report.generate());
	}

	@Test
	public void shouldBeAbleToAddMultipleExpensesByType(){
		Expense dinner = new Expense("Dinner", 1000, 0);
		Expense car = new Expense("Car", 2000, 0);
		Report report = new Report(Arrays.asList(dinner, car));
		assertEquals("Dinner: 1000,Car: 2000\nTotal = 3000", report.generate());
	}
	
	@Test
	public void shouldBeAbleToTotalAddedExpenses(){
		Expense dinner = new Expense("Dinner", 1000, 0);
		Expense car = new Expense("Car", 2000, 0);
		Report report = new Report(Arrays.asList(dinner, car));
		assertEquals("Dinner: 1000,Car: 2000\nTotal = 3000", report.generate());
	}
	
	@Test
	public void shouldTotalExpensesWhichAreAboveSpecifiedLimit(){
		Expense dinner = new Expense("Dinner", 1500, 1000);
		Expense car = new Expense("Car", 2000, 1000);
		Expense Laundry = new Expense("Laundry", 500, 1000);
		Report report = new Report(Arrays.asList(dinner, car, Laundry));
		assertEquals("Dinner: 1500,Car: 2000\nTotal = 3500", report.generate());
	}

}
