package service.split.strategy;

import model.Expense;
import model.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {

    Map<String, Double> calculateSplit(Expense expense, List<User> users);
}
