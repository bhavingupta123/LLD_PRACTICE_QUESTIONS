package model;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {

    private Map<String, Map<String, Double>> sheet = new HashMap<>();

    public void addTransaction(String paidBy, Map<String, Double> splits) {
        for (Map.Entry<String, Double> entry : splits.entrySet()) {
            String paidFor = entry.getKey();
            double amount = entry.getValue();

            if (paidBy.equals(paidFor)) continue; // skip self

            sheet.putIfAbsent(paidFor, new HashMap<>());
            sheet.get(paidFor).put(paidBy, sheet.get(paidFor).getOrDefault(paidBy, 0.0) + amount);

            sheet.putIfAbsent(paidBy, new HashMap<>());
            sheet.get(paidBy).put(paidFor, sheet.get(paidBy).getOrDefault(paidFor, 0.0) - amount);
        }
    }

    public void showBalances() {
        for (Map.Entry<String, Map<String, Double>> entry : sheet.entrySet()) {
            String user = entry.getKey();
            for (Map.Entry<String, Double> b : entry.getValue().entrySet()) {
                if (b.getValue() > 0.0) {
                    System.out.println(user + " owes " + b.getKey() + ": Rs " + b.getValue());
                }
            }
        }
    }
}
