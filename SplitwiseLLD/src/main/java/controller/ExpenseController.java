package controller;

import model.Expense;
import service.ExpenseService;

public class ExpenseController {

    ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public void addExpense(String groupid, Expense expense){
        expenseService.addExpense(groupid, expense);
    }

    public void removeAnExpense(String groupid, String expenseId){
        expenseService.removeAnExpense(groupid, expenseId);
    }

    public void splitExpense(String groupid){
        expenseService.splitExpense(groupid);
    }
}
