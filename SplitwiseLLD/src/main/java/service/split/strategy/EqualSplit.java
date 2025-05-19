package service.split.strategy;

import model.Expense;
import model.User;
import java.util.*;

public class EqualSplit implements SplitStrategy {
    @Override
    public Map<String, Double> calculateSplit(Expense expense, List<User> users) {
        double share = expense.getCost() / users.size();
        Map<String, Double> map = new HashMap<>();
        for (User user : users) {
            map.put(user.getId(), share);
        }
        return map;
    }
}
