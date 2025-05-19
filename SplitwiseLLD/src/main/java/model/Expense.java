package model;

import service.split.strategy.SplitStrategy;

public class Expense {
    private String expenseId;
    private String name;
    private double cost;
    private String ownerId;
    private SplitStrategy splitStrategy;

    public Expense(String expenseId, String name, double cost, String ownerId, SplitStrategy splitStrategy) {
        this.expenseId = expenseId;
        this.name = name;
        this.cost = cost;
        this.ownerId = ownerId;
        this.splitStrategy = splitStrategy;
    }

    public double getCost() {
        return cost;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public SplitStrategy getSplitStrategy() {
        return splitStrategy;
    }
}
