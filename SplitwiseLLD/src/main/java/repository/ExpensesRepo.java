package repository;

import model.Expense;
import model.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpensesRepo {

    private Map<String, List<Expense>> groupListMap = new HashMap<>();

    public void addExpense(String groupid, Expense expense){

        if(groupListMap.get(groupid)==null){
            groupListMap.put(groupid, new ArrayList<>());
        }
        List<Expense> expenseList = groupListMap.get(groupid);
        expenseList.add(expense);
    }

    public void removeAnExpense(String groupid, String expenseId){

    }

    public List<Expense> splitExpense(String groupid){
        List<Expense> expenseList = groupListMap.get(groupid);
        return expenseList;
    }
}
