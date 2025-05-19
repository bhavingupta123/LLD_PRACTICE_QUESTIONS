package service;

import model.Expense;
import repository.ExpensesRepo;

import java.util.List;

public class ExpenseService {
    ExpensesRepo expensesRepo;

    public ExpenseService(ExpensesRepo expensesRepo) {
        this.expensesRepo = expensesRepo;
    }

    public void addExpense(String groupid, Expense expense){
        expensesRepo.addExpense(groupid, expense);
    }

    public void removeAnExpense(String groupid, String expenseId){

    }

    public void splitExpense(String groupid){
        List<Expense> expenseList = expensesRepo.splitExpense(groupid);

    }
}
