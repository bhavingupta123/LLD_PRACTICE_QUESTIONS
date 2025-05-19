package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Group {

    private String groupid;
    private List<Expense> expenseList =new ArrayList<>();
    private List<User> userList =new ArrayList<>();
    private BalanceSheet balanceSheet = new BalanceSheet();

    public Group(String groupid) {
        this.groupid = groupid;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
        Map<String, Double> split = expense.getSplitStrategy().calculateSplit(expense, userList);
        balanceSheet.addTransaction(expense.getOwnerId(), split);
    }

    public void showBalances() {
        balanceSheet.showBalances();
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public String getGroupId() {
        return groupid;
    }
}
